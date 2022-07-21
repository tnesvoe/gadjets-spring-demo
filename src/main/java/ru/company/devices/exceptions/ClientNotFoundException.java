package ru.company.devices.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("User not found; id is " + id);
    }
}
