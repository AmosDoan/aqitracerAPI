package com.tokyoprogrammer.aqitracer.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tokyoprogrammer.aqitracer.controller.AqitracerController;

import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.logging.AccessLogWriter;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;

@Configuration
public class AqitracerConfiguration {

    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator(AqitracerController service) {
        return builder -> {
            builder.serviceUnder("/docs", new DocService());
            builder.decorator(LoggingService.newDecorator());
            builder.accessLogWriter(AccessLogWriter.combined(), false);
            builder.annotatedService(service);
        };
    }
}
