package ru.company.devices.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private CountDownLatch latch = new CountDownLatch(1);

    private String msg;

    @KafkaListener(topics = "${test.topic}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {

        LOGGER.info("received msg='{}'", consumerRecord.toString());

        msg = consumerRecord.toString();
        latch.countDown();
    }

    public String getMsg() {
        return this.msg;
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }

}
