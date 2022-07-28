package ru.company.devices.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.company.devices.entity.Client;

import java.util.concurrent.CountDownLatch;

@Component
public class KafkaClientConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaClientConsumer.class);
    private CountDownLatch latch = new CountDownLatch(1);

    private String newClient;

    @KafkaListener(topics = "${clients}")
    public void receive(Client client) {
        LOGGER.info("received client='{}'", client.toString());
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }

}
