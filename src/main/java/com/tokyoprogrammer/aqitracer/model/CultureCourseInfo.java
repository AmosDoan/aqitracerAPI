package com.tokyoprogrammer.aqitracer.model;

import java.util.List;

import lombok.Data;

@Data
public class CultureCourseInfo {
    private String name;
    private double lat;
    private double lng;
    private String description;
    private String address;

    public static class Response extends ResponseBase<List<CultureCourseInfo>> {

    }
}
