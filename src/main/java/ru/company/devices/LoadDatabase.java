package ru.company.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.company.devices.entity.Device;
import ru.company.devices.entity.Client;
import ru.company.devices.repository.DeviceRepository;
import ru.company.devices.repository.ClientRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    private Client client1 = new Client("Стрелков Дональд Тимофеевич");
    private Client client2 = new Client("Сидоров Никифор Геннадиевич");

    private Device device1 = new Device("brand1", "model1");
    private Device device2 = new Device("brand2", "model2");
    private Device device3 = new Device("brand3", "model3");

    @Bean
    CommandLineRunner initUser(ClientRepository repository) {
        return args -> {
            log.info(repository.save(client1) + " загружен");
            log.info(repository.save(client2) + " загружен");
        };

    }

    @Bean
    CommandLineRunner initDevices(DeviceRepository repository) {
        return args -> {
            device1.setClient(client1);
            device2.setClient(client1);

            log.info("Preloading + " + repository.save(device1));
            log.info("Preloading + " + repository.save(device2));
            log.info("Preloading + " + repository.save(device3));
        };
    }



}
