package com.tsp.sa.entity;

import lombok.Data;

/**
 * 地铁出口
 */
@Data
public class Exit {

    /**
     * 出口名称
     */
    private String name;

    /**
     * 出口经纬度
     */
    private String location;
}
