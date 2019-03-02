package com.tokyoprogrammer.aqitracer.model;

import lombok.Data;

@Data
public abstract class ResponseBase<T> {
    private String result;
    private T data;
}
