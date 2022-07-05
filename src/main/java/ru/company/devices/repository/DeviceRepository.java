package ru.company.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.company.devices.entity.Device;

import java.util.List;


// create new devices
// update existing devices
// delete devices
// find (все, один, или девайсы по критериям)

// создание, обновление или удаление устройств
// поиск устройств

public interface DeviceRepository extends JpaRepository<Device, Long> {

}