package com.tokyoprogrammer.aqitracer.model;

import java.util.List;

import lombok.Data;

@Data
public class WalkCourseInfo {
    private String name;
    private String distance;
    private int aqi;
    private List<Location> location;

    @Data
    public static class Location {
        private double lat;
        private double lng;
    }

    public static class Response extends ResponseBase<List<WalkCourseInfo>> {

    }
}
