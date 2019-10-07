package com.tsp.sa.service;

import com.tsp.sa.entity.City;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaService {

    /** 初始温度 */
    private Double T = 50000.0;

    /** 温度下限 */
    private Double T_min = 1e-8;

    /** 退火系数 */
    private Double r = 0.98;

    /** 每个温度的迭代次数 */
    private Integer L = 100;

    /** 城市 第一个城市为起点 */
    private List<City> cityList = new ArrayList<>();

    /** 各点到其他点的距离 */
    private double[][] distance = {{0,1,3,2,2.5},{1,0,2,1,2},{3,2,0,1,1.5},{2,1,1,0,1.5},{2.5,2,1.5,1.5,0}};


    public void sa(){
        List<City> result = new ArrayList<>();
        List<City> cop = new ArrayList<>();

        City city1 = new City(0,0.0,0.0);
        City city2 = new City(1,5.0,6.0);
        City city3 = new City(2,12.0,13.0);
        City city4 = new City(3,1.5,23.3);
        City city5 = new City(4,14.4,7.8);
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
        cityList.add(city5);
        cityList.add(city1);
        cop.addAll(cityList);
        result.addAll(cityList);

        Double t = T;
        Double dis = 0.0;
        int count = 0;
        while (t >= T_min){

            for (int i =0;i<L;i++){

                cop = randomCity(cop);
                double d1 = getDistance(result);
                double d2 = getDistance(cop);
                double de = d2 - d1;
                if (de <= 0){
                    result.clear();
                    result.addAll(cop);
                    dis = d2;
                }else {
                    if (Math.exp(-de/t)>Math.random()){
                        result.clear();
                        result.addAll(cop);
                        dis = d2;
                    }
                }

            }
            t *= r;
            count++;
        }

        System.out.println(result);
        System.out.println(dis);
        System.out.println(count);
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


}
