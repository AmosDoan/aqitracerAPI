package com.tokyoprogrammer.aqitracer.model;

import java.util.Collections;
import java.util.Map;

import lombok.Data;

@Data
public class AqiDetailData {
    private String name;
    private double lat;
    private double lng;
    private Map<String, Double> aqiInfo = Collections.emptyMap();
}