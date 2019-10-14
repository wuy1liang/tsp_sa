package com.tsp.sa.entity;

import lombok.Data;

@Data
public class City {

    private Integer id;

    private String location;

    public City(Integer id, String location) {
        this.id = id;
        this.location = location;
    }

}