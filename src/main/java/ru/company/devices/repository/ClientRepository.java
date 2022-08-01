package ru.company.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.company.devices.entity.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.name LIKE %:name% OR c.surname LIKE %:name%")
    List<Client> findByName(@Param("name") String name);
}
