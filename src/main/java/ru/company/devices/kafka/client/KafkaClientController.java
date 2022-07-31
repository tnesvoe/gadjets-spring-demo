package ru.company.devices.kafka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import ru.company.devices.entity.Client;
import ru.company.devices.kafka.client.producer.ClientProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaClientController {
    @Autowired
    private ClientProducer clientProducer;

    @PostMapping("/new_client")
    public void postKafka(@RequestParam("message") Client message) {
        clientProducer.send("clients", message);
    }
}
