package ru.company.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.devices.entity.DeviceUser;

public interface UserRepository extends JpaRepository<DeviceUser, Long> {
}
