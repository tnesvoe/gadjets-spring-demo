package ru.company.devices.exceptions;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException(Long id) {
        super("Could not found device with id " + id);
    }
}
