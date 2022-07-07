package ru.company.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.company.devices.entity.DeviceUser;
import ru.company.devices.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<DeviceUser> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    DeviceUser getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping("/users")
    DeviceUser addUser(@RequestBody DeviceUser deviceUser) {
        return userRepository.save(deviceUser);
    }

    @PutMapping("/users/{id}")
    DeviceUser putUser(@RequestBody DeviceUser deviceUser, @PathVariable Long id) {
        return userRepository.save(deviceUser);
    }

    @DeleteMapping("/users/{id}")
    void delUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
