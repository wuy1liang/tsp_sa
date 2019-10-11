package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 * 公交换乘信息
 */
@Data
public class Route {

    /**
     * 起点坐标
     */
    private String origin;

    /**
     * 终点坐标
     */
    private String destination;

    /**
     * 起点和终点的步行距离
     */
    private String distance;

    /**
     * 出租车费用
     */
    private String taxi_cost;

    /**
     * 公交换乘方案列表
     */
    private List<Transit> transits;

}
