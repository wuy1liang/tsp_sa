package com.tsp.sa.entity;

import lombok.Data;

/**
 *  高德公交路径规划数据
 */
@Data
public class GaodeTransitDirectionData {

    private String status;

    private String info;

    private String infocode;

    private String count;

    private Route route;

}
