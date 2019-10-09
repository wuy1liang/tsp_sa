package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 *  公交换乘方案
 */
@Data
public class Transit {

    private String cost;

    private String duration;

    private String nightflag;

    private String walking_distance;

    private String distance;

    private String missed;

    private List<Segment> segments;
}
