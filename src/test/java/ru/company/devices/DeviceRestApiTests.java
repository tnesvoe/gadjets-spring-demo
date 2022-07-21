package ru.company.devices;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.company.devices.controller.DeviceController;

import static ru.company.devices.HttpService.serveClient;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class DeviceRestApiTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testEndpoints() throws ClientProtocolException, IOException {
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        ResponseEntity<String> devices = restTemplate.getForEntity("/devices", String.class);
        Assertions.assertEquals(devices.getStatusCode(), HttpStatus.OK);
        ResponseEntity<String> clients = restTemplate.getForEntity("/clients", String.class);
        Assertions.assertEquals(clients.getStatusCode(), HttpStatus.OK);
    }
}
