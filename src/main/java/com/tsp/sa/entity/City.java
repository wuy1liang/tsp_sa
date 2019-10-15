package com.tsp.sa.entity;

import lombok.Data;

@Data
public class City {

    private Integer id;

    private String location;

    private String formatted_address;

    private String citycode;

    public City(Integer id, String location, String formatted_address, String citycode) {
        this.id = id;
        this.location = location;
        this.formatted_address = formatted_address;
        this.citycode = citycode;
    }
}