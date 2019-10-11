package com.tsp.sa.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsp.sa.entity.GaodeTransitDirectionData;
import com.tsp.sa.entity.Route;
import com.tsp.sa.entity.Transit;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JsonUtil {

    public static GaodeTransitDirectionData json2Data(String json){

        JSONObject object = JSON.parseObject(json);

        GaodeTransitDirectionData data = new GaodeTransitDirectionData();

        data.setStatus(object.getString("status"));
        data.setInfo(object.getString("info"));
        data.setCount(object.getString("count"));
        data.setInfocode(object.getString("infocode"));
        JSONObject routeJson = object.getJSONObject("route");
        Route route = json2Route(routeJson);
        data.setRoute(route);

        return data;
    }

    public static Route json2Route(JSONObject routeJson) {
        Route route = new Route();

        route.setOrigin(routeJson.getString("origin"));
        route.setDestination(routeJson.getString("destination"));
        route.setDistance(routeJson.getString("distance"));
        route.setTaxi_cost(routeJson.getString("taxi_cost"));

        JSONArray transitArray = routeJson.getJSONArray("transits");
        List<Transit> transits = new ArrayList<>();
        for (int i = 0;i < transitArray.size(); i++ ){
            Transit transit = json2Transit(transitArray.getJSONObject(i));
            transits.add(transit);
        }
        route.setTransits(transits);

        return route;
    }

    public static Transit json2Transit(JSONObject jsonObject) {
        Transit transit = new Transit();


        return transit;
    }
}
