package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 * 公交换乘信息
 */
@Data
public class Route {

    private String origin;

    private String destination;

    private String distance;

    private String taxi_cost;

    private List<Transit> transits;

}
