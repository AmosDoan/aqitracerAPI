package com.tokyoprogrammer.aqitracer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AqitracerController {

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "OK";
    }
}
