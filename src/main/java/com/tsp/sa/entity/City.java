package com.tsp.sa.entity;

import lombok.Data;

@Data
public class City {

    private Integer id;

    private Double jd;

    private Double wd;

    public City(Integer id, Double jd, Double wd) {
        this.id = id;
        this.jd = jd;
        this.wd = wd;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                '}';
    }
}