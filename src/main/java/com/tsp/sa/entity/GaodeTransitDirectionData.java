package com.tsp.sa.entity;

import lombok.Data;

/**
 *  高德公交路径规划数据
 */
@Data
public class GaodeTransitDirectionData {

    /**
     * 返回状态
     */
    private String status;

    /**
     * 返回的状态信息
     */
    private String info;

    /**
     * 状态码
     */
    private String infocode;

    /**
     * 公交换乘方案数目
     */
    private String count;

    /**
     * 公交换乘信息列表
     */
    private Route route;

}
