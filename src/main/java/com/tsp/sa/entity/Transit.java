package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 *  公交换乘方案
 */
@Data
public class Transit {

    /**
     * 价格
     */
    private String cost;

    /**
     * 预期时间
     */
    private String duration;

    /**
     * 是否是夜班车
     * 0：非夜班车；1：夜班车
     */
    private String nightflag;

    /**
     * 总步行距离
     */
    private String walking_distance;

    /**
     * 换乘路段列表
     */
    private List<Segment> segments;

    private String distance;

    private String missed;

}
