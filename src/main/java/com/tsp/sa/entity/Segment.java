package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 *  换乘路段
 */
@Data
public class Segment {

    /**
     * 此路段步行导航信息
     */
    private Walking walking;

    /**
     * 此路段公交导航信息
     */
    private List<Busline> buslines;

    /**
     * 地铁入口(只在地铁路段有值)
     */
    private Entrance entrance;

    /**
     * 地铁出口(只在地铁路段有值)
     */
    private Exit exit;

    /**
     * 乘坐地铁的信息(只在地铁路段有值)
     */
    private Railway railway;
}
