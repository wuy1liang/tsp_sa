package com.tsp.sa.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsp.sa.entity.*;

import java.util.ArrayList;
import java.util.List;

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

        transit.setCost(jsonObject.getString("cost"));
        transit.setDistance(jsonObject.getString("duration"));
        transit.setNightflag(jsonObject.getString("nightflag"));
        transit.setWalking_distance(jsonObject.getString("walking_distance"));

        JSONArray segmentArray = jsonObject.getJSONArray("segments");
        List<Segment> segments = new ArrayList<>();
        for (int i = 0;i < segmentArray.size();i++){

            Segment segment = json2Segment(segmentArray.getJSONObject(i));
            segments.add(segment);

        }
        transit.setSegments(segments);

        return transit;
    }

    public static Segment json2Segment(JSONObject jsonObject) {

        Segment segment = new Segment();

        Walking walking = json2Walking(jsonObject.getJSONObject("walking"));
        segment.setWalking(walking);

        JSONObject busJson = jsonObject.getJSONObject("bus");
        List<Busline> buslineList = new ArrayList<>();
        if (busJson != null){
            JSONArray buslines = busJson.getJSONArray("buslines");
            for (int i = 0;i < buslines.size();i++){
                Busline busline = json2Busline(buslines.getJSONObject(i));
                buslineList.add(busline);
            }
        }
        segment.setBuslines(buslineList);


        return segment;
    }

    private static Busline json2Busline(JSONObject jsonObject) {
        return null;
    }

    private static Walking json2Walking(JSONObject walking) {
        return null;
    }
}
