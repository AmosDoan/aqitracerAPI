package com.tokyoprogrammer.aqitracer.model;

import java.util.List;

import lombok.Data;

@Data
public class AqiInfo {
    private AqiDetailData currentData;
    private List<AqiData> mapData;

    public static class Response extends ResponseBase<AqiInfo> {

    }
}
