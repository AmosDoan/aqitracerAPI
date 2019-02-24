package com.tokyoprogrammer.aqitracer.controller;

import org.springframework.stereotype.Component;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.internal.shaded.guava.collect.ImmutableMap;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.Path;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AqitracerController {

    private enum AQI_PROVIDER {
        WAQI,
        KECO,
        EUROPE,
    };

    private enum ETC_TYPE {
        WALK,
        CULTURE
    };

    @Get
    @Path("/healthCheck")
    public HttpResponse healthCheck() {
        return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, "OK");
    }

    @Get
    @Path("/api/v1/aqi")
    public String getAqi(@Param("latlng") String latlng, @Param("provider") AQI_PROVIDER provider) {
        return ImmutableMap.of("coordinate", latlng, "provider", provider).toString();
    }

    @Get
    @Path("/api/v1/etc")
    public String getEtc(@Param("type") ETC_TYPE type) {
        return type.name();
    }
}
