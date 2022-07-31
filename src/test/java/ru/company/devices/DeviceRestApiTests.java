package ru.company.devices;

import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import ru.company.devices.entity.Device;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

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

    @Test
    void testPost() {
        Device device = new Device("smartphone", "snapdragon 600", 8, 4096, "Xiaomi 12 Pro", "12 Pro");
        ResponseEntity<String> response = restTemplate.postForEntity("/devices", device, String.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void testPut() {
        Device device = new Device("smartphone", "snapdragon 600", 8, 4096, "realme", "GT NEO2");
        ResponseEntity<String> responseOnPut;

        responseOnPut = restTemplate.exchange("/devices",
                HttpMethod.PUT,
                new HttpEntity<>(device),
                String.class,
                Collections.singletonMap("id", "1"));

        System.out.println(responseOnPut.getBody());
        System.out.println(responseOnPut.getStatusCode());
    }

    @Test
    void testDelete() {
        restTemplate.delete("/devices/1");
        // ensure
    }
}
