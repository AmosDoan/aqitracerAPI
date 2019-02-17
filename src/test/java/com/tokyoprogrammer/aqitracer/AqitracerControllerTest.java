package com.tokyoprogrammer.aqitracer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.linecorp.armeria.client.HttpClient;
import com.linecorp.armeria.common.AggregatedHttpMessage;
import com.linecorp.armeria.common.HttpStatus;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class AqitracerControllerTest {

    private final HttpClient client = HttpClient.of("http://localhost:8080");

    @Test
    public void successHealthCheck() {
        final AggregatedHttpMessage response = client.get("/healthCheck").aggregate().join();
        assertThat(response.status()).isEqualTo(HttpStatus.OK);
        assertThat(response.content().toStringUtf8())
                .isEqualTo("OK");
    }

    @Test
    public void successAqi() {
        final AggregatedHttpMessage response = client.get("/api/v1/aqi?latlng=test&provider=WAQI").aggregate().join();
        assertThat(response.status()).isEqualTo(HttpStatus.OK);
    }
}
