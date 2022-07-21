package ru.company.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.company.devices.entity.Device;
import ru.company.devices.exceptions.DeviceNotFoundException;
import ru.company.devices.repository.DeviceRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    DeviceRepository deviceRepository;

    @PostMapping("/devices")
    Device addNewDevice(@RequestBody Device newDevice) {
        return deviceRepository.save(newDevice);
    }

    @GetMapping("/devices")
    List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/devices/{id}")
    Device getDevice(@PathVariable long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new DeviceNotFoundException(id));
    }

    @PutMapping("/devices/{id}")
    Device putDevice(@RequestBody Device newDevice, @PathVariable long id) {
        return deviceRepository
                .findById(id)
                .map(device -> {
                    device.setBrand(newDevice.getBrand());
                    device.setModel(newDevice.getModel());
                    return deviceRepository.save(device);
                })
                .orElseGet(() -> {
                    newDevice.setId(id);
                    return deviceRepository.save(newDevice);
                });
    }

    @DeleteMapping("/devices/{id}")
    void deleteDevice(@PathVariable Long id) {
        deviceRepository.deleteById(id);
    }

}
