package ru.company.devices.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.company.devices.entity.Client;

/*  This class provides high-level thread-safe operations, such as sending data to the provided topic, which is exactly what we do in our send method. */
@Component
public class KafkaClientProducer {
    @Autowired
    private KafkaTemplate<String, Client> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaClientProducer.class);

    public void send(String topic, Client client) {
        LOGGER.info("sending client='{}' to topic='{}'", client, topic);
        kafkaTemplate.send(topic, client);
    }
}
