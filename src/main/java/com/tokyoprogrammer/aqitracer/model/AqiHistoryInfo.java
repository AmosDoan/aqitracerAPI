package com.tokyoprogrammer.aqitracer.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AqiHistoryInfo {
    @JsonProperty("aqi_history")
    Map<String, AqiHistoryDetail> aqiHistory = new HashMap<>();

    @Data
    private static class AqiHistoryDetail  {
        private String pm10;
        private String pm25;
    }
    public static class Response extends ResponseBase<AqiHistoryInfo> {

    }
}
