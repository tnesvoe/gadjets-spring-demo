package ru.company.devices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.company.devices.controller.DeviceController;

import java.net.http.HttpResponse;

import static ru.company.devices.HttpService.serveClient;

import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class DeviceRestApiTests {

    @Autowired
    DeviceController deviceController;

    @Test
    void autowiredWorks() {
        assertThat(deviceController).isNotNull();
    }

    @Test
    void testReturn200() throws java.io.IOException, java.lang.InterruptedException, java.net.URISyntaxException {
        HttpResponse<String> response = serveClient("http://localhost:8080/");
        Assertions.assertEquals(response.statusCode(), 200);
    }

    @Test
    void testDevices() {
        HttpUriRequest
    }
}
