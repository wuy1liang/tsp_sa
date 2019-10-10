package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 *  步行导航信息
 */
@Data
public class Walking {

    /**
     * 起点坐标
     */
    private String origin;

    /**
     * 终点坐标
     */
    private String destination;

    /**
     * 每段线路步行距离
     */
    private String distance;

    /**
     * 步行预计时间
     */
    private String duration;

    /**
     * 步行路段列表
     */
    private List<Step> steps;

}
