package ru.company.devices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import ru.company.devices.entity.Client;
import ru.company.devices.kafka.client.consumer.ClientConsumer;
import ru.company.devices.kafka.client.producer.ClientProducer;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* We also use the @DirtiesContext annotation, which will make sure this context is cleaned and reset between different tests. */
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9093", "port=9093" })
public class KafkaTest {
    @Autowired
    private ClientConsumer consumer;

    static {
        System.setProperty(EmbeddedKafkaBroker.BROKER_LIST_PROPERTY,
                "spring.kafka.bootstrap-servers");
    }

    @Autowired
    private ClientProducer producer;

    @Value("${clients}")
    private String topic;

    @Test
    public void testEmbeddedKafkaBroker()
            throws Exception {
        producer.send(topic, new Client("Кормышев Мастер Андреевич", 79955554433L, "humanbean@on.com"));

        boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
        assertTrue(messageConsumed);

        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(consumer.getLatch().getCount()).isEqualTo(0);
    }
}
