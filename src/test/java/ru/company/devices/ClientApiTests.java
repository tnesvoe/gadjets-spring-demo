package ru.company.devices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.company.devices.entity.Device;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientApiTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testFindByName() {

        ResponseEntity<String> response = restTemplate.getForEntity("/clients", String.class, Collections.singletonMap("name", "Ждан"));

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
