package com.tokyoprogrammer.aqitracer.controller;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tokyoprogrammer.aqitracer.model.AqiHistoryInfo;
import com.tokyoprogrammer.aqitracer.model.AqiInfo;
import com.tokyoprogrammer.aqitracer.model.CultureCourseInfo;
import com.tokyoprogrammer.aqitracer.model.WalkCourseInfo;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.Path;

import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AqitracerController {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private <T> T getDummyResponse(String jsonPath, Class<T> classType) throws IOException {
        // dummy data
        final String json = IOUtils
                .toString(getClass().getClassLoader().getResourceAsStream(jsonPath));

        return OBJECT_MAPPER.readValue(json, classType);
    }

    @Get
    @Path("/healthCheck")
    public HttpResponse healthCheck() {
        return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, "OK");
    }

    @Get
    @Path("/api/v1/aqi")
    public HttpResponse getAqi(@Param("current") String current, @Param("bound") String bound) {
        /*
         * TODO : logic will be replaced by below
         *
         * 1. Call WAQI,KECO,EUROPE API and deserialize to their own model class
         * 2. Converting the response model class to our client model class (AqiInfo.Response)
         */
        AqiInfo.Response response;
        try {
            response = getDummyResponse("aqi-dummy-response.json", AqiInfo.Response.class);
        } catch (IOException ignored) {
            response = new AqiInfo.Response();
        }

        return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, response.toString());
    }

    @Get
    @Path("/api/v1/aqi_history")
    public HttpResponse getAqiHistory(@Param("current") String current, @Param("from") String from,
                                      @Param("to") String to) {
        /*
         * TODO : logic will be replaced by below
         *
         * 1. Call WAQI,KECO,EUROPE API and deserialize to their own model class
         * 2. Converting the response model class to our client model class (AqiInfo.Response)
         */
        AqiHistoryInfo.Response response;
        try {
            response = getDummyResponse("aqi-history-dummy-response.json", AqiHistoryInfo.Response.class);
        } catch (IOException ignored) {
            response = new AqiHistoryInfo.Response();
        }

        return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, response.toString());
    }

    @Get
    @Path("/api/v1/culture")
    public HttpResponse getCultureCourse() {
        /*
         * TODO : logic will be replaced by below
         *
         * 1. Call Seoul-city culture course API and deserialize to their own model class
         * 2. Converting the response model class to our client model class (CultureCourseInfo.Response)
         */
        CultureCourseInfo.Response response;
        try {
            response = getDummyResponse("culture-dummy-response.json", CultureCourseInfo.Response.class);
        } catch (IOException ignored) {
            response = new CultureCourseInfo.Response();
        }

        return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, response.toString());
    }

    @Get
    @Path("/api/v1/walk")
    public HttpResponse getWalkCourse() {
        /*
         * TODO : logic will be replaced by below
         *
         * 1. Call Seoul-walk culture course API and deserialize to their own model class
         * 2. Converting the response model class to our client model class (WalkCourseInfo.Response)
         */
        WalkCourseInfo.Response response;
        try {
            response = getDummyResponse("walk-dummy-response.json", WalkCourseInfo.Response.class);
        } catch (IOException ignored) {
            response = new WalkCourseInfo.Response();
        }

        return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, response.toString());
    }
}
