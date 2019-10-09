package com.tsp.sa.entity;

import lombok.Data;

import java.util.List;

/**
 *  换乘路段
 */
@Data
public class Segment {

    private Walking walking;

    private List<Busline> buslines;

    private Entrance entrance;

    private Exit exit;

    private Railway railway;
}
