package ru.company.devices.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import ru.company.devices.entity.Client;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final KafkaClientProducer producer;

    @Autowired
    public KafkaController(KafkaClientProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/new_client")
    public void postKafka(@RequestParam("message") Client message) {
        producer.send("clients", message);
    }
}
