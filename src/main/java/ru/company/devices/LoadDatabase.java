package ru.company.devices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.company.devices.entity.Device;
import ru.company.devices.entity.DeviceUser;
import ru.company.devices.repository.DeviceRepository;
import ru.company.devices.repository.UserRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDevices(DeviceRepository repository) {
        return args -> {
            log.info("Preloading + " + repository.save(new Device("brand1", "model1")));
            log.info("Preloading + " + repository.save(new Device("brand1", "model2")));
        };
    }

    @Bean
    CommandLineRunner initUser(UserRepository repository) {
        return args -> {
            log.info(new DeviceUser("Муромец", "Илья", "сын Ивана") + " загружен");
        };
    }
}
