package com.tsp.sa.entity;

import lombok.Data;

@Data
public class GaodeTransitDirectionRequestParameters {

    /**
     *  权限key
     */
    private String key;

    /**
     * 出发点
     */
    private String origin;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 起点城市
     */
    private String city;

    /**
     * 终点城市
     */
    private String cityd;

    /**
     *  规划策略
     *  0：最快捷模式
     * 1：最经济模式
     * 2：最少换乘模式
     * 3：最少步行模式
     * 5：不乘地铁模式
     */
    private String strategy;

    /**
     *  数字签名
     */
    private String sig;
}
