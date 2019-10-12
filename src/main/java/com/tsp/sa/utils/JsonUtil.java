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

        Entrance entrance = json2Entrance(jsonObject.getJSONObject("entrance"));
        segment.setEntrance(entrance);

        Exit exit = json2Exit(jsonObject.getJSONObject("exit"));
        segment.setExit(exit);

        Railway railway = json2Railway(jsonObject.getJSONObject("railway"));
        segment.setRailway(railway);

        return segment;
    }

    public static Railway json2Railway(JSONObject jsonObject) {
        Railway railway = new Railway();
        return railway;
    }

    public static Exit json2Exit(JSONObject jsonObject) {
        Exit exit = new Exit();
        exit.setLocation(jsonObject.getString("location"));
        exit.setName(jsonObject.getString("name"));
        return exit;
    }

    public static Entrance json2Entrance(JSONObject jsonObject) {
        Entrance entrance = new Entrance();
        entrance.setLocation(jsonObject.getString("location"));
        entrance.setName(jsonObject.getString("name"));
        return entrance;
    }

    public static Busline json2Busline(JSONObject jsonObject) {
        Busline busline =new Busline();

        Station departure_stop = json2Station(jsonObject.getJSONObject("departure_stop"));
        busline.setDeparture_stop(departure_stop);

        Station arrival_stop = json2Station(jsonObject.getJSONObject("arrival_stop"));
        busline.setArrival_stop(arrival_stop);

        busline.setName(jsonObject.getString("arrival_stop"));
        busline.setId(jsonObject.getString("id"));
        busline.setType(jsonObject.getString("type"));
        busline.setDistance(jsonObject.getString("distance"));
        busline.setDuration(jsonObject.getString("duration"));
        busline.setPolyline(jsonObject.getString("polyline"));
        busline.setStart_time(jsonObject.getString("start_time"));
        busline.setEnd_time(jsonObject.getString("start_time"));
        busline.setVia_num(jsonObject.getString("via_num"));

        JSONArray via_stops = jsonObject.getJSONArray("via_stops");
        List<Station> viaStops = new ArrayList<>();
        for (int i = 0;i < via_stops.size();i++){
            Station station = json2Station(via_stops.getJSONObject(i));
            viaStops.add(station);
        }
        busline.setVia_stops(viaStops);

        return busline;
    }

    private static Station json2Station(JSONObject jsonObject) {
        Station station = new Station();
        station.setId(jsonObject.getString("id"));
        station.setName(jsonObject.getString("name"));
        station.setLocation(jsonObject.getString("location"));
        return station;
    }

    public static Walking json2Walking(JSONObject jsonObject) {
        Walking walking = new Walking();

        walking.setOrigin(jsonObject.getString("origin"));
        walking.setDestination(jsonObject.getString("destination"));
        walking.setDistance(jsonObject.getString("distance"));
        walking.setDuration(jsonObject.getString("duration"));

        JSONArray stepArray = jsonObject.getJSONArray("steps");
        List<Step> steps = new ArrayList<>();
        for (int i = 0;i < stepArray.size();i++){
            Step step = json2Step(stepArray.getJSONObject(i));
            steps.add(step);
        }
        walking.setSteps(steps);

        return walking;
    }

    public static Step json2Step(JSONObject jsonObject) {
        Step step = new Step();

        step.setAction(jsonObject.getString("action"));
        step.setAssistant_action(jsonObject.getString("assistant_action"));
        step.setPolyline(jsonObject.getString("polyline"));
        step.setDuration(jsonObject.getString("duration"));
        step.setDistance(jsonObject.getString("distance"));
        step.setRoad(jsonObject.getString("road"));
        step.setInstruction(jsonObject.getString("instruction"));

        return step;
    }
}
