package ru.company.devices.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User not found; id is " + id);
    }
}
