package ru.company.devices.kafka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import ru.company.devices.entity.Client;
import ru.company.devices.kafka.client.producer.ClientProducer;

@RestController
@RequestMapping(value = "/kafka")
@PropertySource(value={"classpath:application.properties"})
public class KafkaClientController {
    @Autowired
    private final ClientProducer producer;

    public KafkaClientController(ClientProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/new_client")
    public void postKafka(@RequestParam("message") Client message) {
        producer.send("clients", message);
    }
}
