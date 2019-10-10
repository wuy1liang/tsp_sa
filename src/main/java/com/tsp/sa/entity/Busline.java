package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 *  公交导航信息
 */
@Data
public class Busline {

    /**
     * 起乘站
     */
    private Station departure_stop;

    /**
     * 下车站
     */
    private Station arrival_stop;

    /**
     * 公交路线名称
     */
    private String name;

    /**
     * 公交路线id
     */
    private String id;

    /**
     * 公交类型
     */
    private String type;

    /**
     * 公交行驶距离
     */
    private String distance;

    /**
     * 公交预计行驶时间
     */
    private String duration;

    /**
     * 此路段坐标集
     */
    private String polyline;

    /**
     * 首班车时间
     */
    private String start_time;

    /**
     * 末班车时间
     */
    private String end_time;

    /**
     * 此段途经公交站数
     */
    private String via_num;

    /**
     * 此段途经公交站点列表
     */
    private List<Station> via_stops;
}
