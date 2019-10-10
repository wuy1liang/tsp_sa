package com.tsp.sa.entity;

import lombok.Data;

/**
 * 步行路段
 */
@Data
public class Step {

    /**
     *此段路的行走介绍
     */
    private String instruction;

    /**
     * 路的名字
     */
    private String road;

    /**
     * 此段路的距离
     */
    private String distance;

    /**
     * 此段路预计消耗时间
     */
    private String duration;

    /**
     * 此段路的坐标
     */
    private String polyline;

    /**
     * 步行主要动作
     */
    private String action;

    /**
     * 步行辅助动作
     */
    private String assistant_action;

}
