package com.tsp.sa.entity;

import lombok.Data;

/**
 * 地铁入口
 */
@Data
public class Entrance {

    /**
     * 入口名称
     */
    private String name;

    /**
     * 入口经纬度
     */
    private String location;
}
