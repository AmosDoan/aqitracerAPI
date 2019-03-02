package com.tokyoprogrammer.aqitracer.model;

import lombok.Data;

@Data
public class AqiData {
    private double lat;
    private double lng;
    private int aqi;
}
