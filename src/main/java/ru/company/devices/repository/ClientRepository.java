package ru.company.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.devices.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
