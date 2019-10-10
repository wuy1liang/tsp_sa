package com.tsp.sa.entity;

import lombok.Data;

/**
 *  站点信息
 */
@Data
public class Station {

    /**
     * 站点名字
     */
    private String name;

    /**
     * id
     */
    private String id;

    /**
     * 站点经纬度
     */
    private String location;
}
