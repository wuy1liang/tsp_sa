package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

@Data
public class GeocodeRegeoResponseData {

    private String status;

    private String info;

    private String infocode;

    private List<Regeocode> regeocodes;

}
