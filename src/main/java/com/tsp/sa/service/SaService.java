package com.tsp.sa.service;

import com.tsp.sa.entity.*;
import com.tsp.sa.properties.SaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaService {

    @Autowired
    GaodeService gaodeService;

    @Autowired
    SaProperties saProperties;

    /** 城市 第一个城市为起点 */
    private List<City> cityList = new ArrayList<>();

    /** 各点到其他点的距离 */
    private double[][] distance;

    /** 各点之间的路线信息 */
    private Route[][] routes;

    /** 退火次数 */
    private Integer countS;

    /** 迭代次数 */
    private Integer couuntL;

    public void sa(String origin, List<String> destinations, String strategy){

        init(origin,destinations,strategy);

        List<City> result = new ArrayList<>();
        List<City> cop = new ArrayList<>();
        cop.addAll(cityList);
        result.addAll(cityList);

        Double t = saProperties.getT();
        Double t_min = saProperties.getT_min();
        Integer L = saProperties.getL();
        Double r = saProperties.getR();
        countS = 0;
        couuntL = 0;

        while (t >= t_min){
            for (int i =0;i<L;i++){
                cop = randomCity(cop);
                double d1 = getDistance(result);
                double d2 = getDistance(cop);
                double de = d2 - d1;
                if (de <= 0){
                    result.clear();
                    result.addAll(cop);
                }else {
                    if (Math.exp(-de/t)>Math.random()){
                        result.clear();
                        result.addAll(cop);
                    }
                }
                couuntL++;
            }
            t *= r;
            countS++;
        }

        System.out.println(result);
        System.out.println("退火次数："+countS);
        System.out.println("迭代次数："+couuntL);
    }

    private double getDistance(List<City> result) {
        double sum = 0.0;
        for (int i = 0;i < result.size()-1 ; i++ ){
            int a = result.get(i).getId();
            int b = result.get(i+1).getId();
            sum += distance[a][b];
        }
        return sum;
    }

    private List<City> randomCity(List<City> result) {
        int i = (int)(Math.random() * (result.size()-2)+1);
        int j = (int)(Math.random() * (result.size()-2)+1);
        result.set(i,result.set(j,result.get(i)));
        return  result;
    }

    private void init(String origin, List<String> destinations, String strategy){

        /**
         *  cityList 初始化
         */
        cityList.clear();
        GeocodeRegeoRequestParameters regeoRequestParameters = new GeocodeRegeoRequestParameters();
        regeoRequestParameters.setLocation(origin);
        GeocodeRegeoResponseData startCode = gaodeService.getGeocode(regeoRequestParameters);
        City start = new City(0,origin,startCode.getRegeocodes().get(0).getFormatted_address(),startCode.getRegeocodes().get(0).getCitycode());

        cityList.add(start);
        for (int i = 0;i < destinations.size();i++){
            regeoRequestParameters.setLocation(destinations.get(i));
            GeocodeRegeoResponseData geocode = gaodeService.getGeocode(regeoRequestParameters);
            City destination = new City(i+1,destinations.get(i),geocode.getRegeocodes().get(0).getFormatted_address(),geocode.getRegeocodes().get(0).getCitycode());
            cityList.add(destination);
        }
        City end = new City(0,origin,startCode.getRegeocodes().get(0).getFormatted_address(),startCode.getRegeocodes().get(0).getCitycode());
        cityList.add(end);

        /**
         *  distance routes初始化
         */
        distance = new double[cityList.size()-1][cityList.size()-1];
        routes = new Route[cityList.size()-1][cityList.size()-1];
        for (int i = 0;i < cityList.size()-1; i++){
            for (int j = 0;j < cityList.size()-1; j++){
                if (i != j){
                    try {
                        GaodeTransitDirectionResponseData data = queryGaode(i,j,strategy);
                        String duration = data.getRoute().getTransits().get(0).getDuration();
                        distance[i][j] = Double.valueOf(duration);
                        routes[i][j] = data.getRoute();
                    }catch (Exception e){
                        distance[i][j] = Double.MAX_VALUE;
                    }
                }else {
                    distance[i][j] = 0;
                }
            }
        }
    }

    private GaodeTransitDirectionResponseData queryGaode(Integer i, Integer j, String strategy) {

        City city1 = cityList.get(i);
        City city2 = cityList.get(j);

        GaodeTransitDirectionRequestParameters parameters = new GaodeTransitDirectionRequestParameters();

        parameters.setOrigin(city1.getLocation());
        parameters.setDestination(city2.getLocation());
        parameters.setStrategy(strategy);

        parameters.setCity(city1.getCitycode());
        parameters.setCityd(city2.getCitycode());

        GaodeTransitDirectionResponseData distance = gaodeService.getDistance(parameters);
        return distance;
    }

}
