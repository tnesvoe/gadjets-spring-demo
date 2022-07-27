package ru.company.devices.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/*  This class provides high-level thread-safe operations, such as sending data to the provided topic, which is exactly what we do in our send method. */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    public void send(String topic, String msg) {
        LOGGER.info("sending msg='{}' to topic='{}'", msg, topic);
        kafkaTemplate.send(topic, msg);
    }
}
