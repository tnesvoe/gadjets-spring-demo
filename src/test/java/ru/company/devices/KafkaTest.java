package ru.company.devices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import ru.company.devices.entity.Client;
import ru.company.devices.kafka.KafkaClientConsumer;
import ru.company.devices.kafka.KafkaClientProducer;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* We also use the @DirtiesContext annotation, which will make sure this context is cleaned and reset between different tests. */
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class KafkaTest {
    @Autowired
    private KafkaClientConsumer consumer;

    static {
        System.setProperty(EmbeddedKafkaBroker.BROKER_LIST_PROPERTY,
                "spring.kafka.bootstrap-servers");
    }

    @Autowired
    private KafkaClientProducer producer;

    @Value("${clients}")
    private String topic;

    @Test
    public void testEmbeddedKafkaBroker()
            throws Exception {
        String data = "Sending with our own simple KafkaProducer";

        producer.send(topic, new Client("Сидоров Мастер Геннадиевич", 79955554433L, "sidoors@band.bam"));

        boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
        assertTrue(messageConsumed);

        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(consumer.getLatch().getCount()).isEqualTo(0);
    }
}
