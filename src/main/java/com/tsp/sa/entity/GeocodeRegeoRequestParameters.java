package com.tsp.sa.entity;

import lombok.Data;

@Data
public class GeocodeRegeoRequestParameters {

    private String key;

    private String location;

    private String batch;

    private String sig;
}
