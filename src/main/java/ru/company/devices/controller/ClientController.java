package ru.company.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.company.devices.entity.Client;
import ru.company.devices.repository.ClientRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientRepository userRepository;

    @GetMapping("/users")
    List<Client> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    Client getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping("/users")
    Client addUser(@RequestBody Client deviceUser) {
        return userRepository.save(deviceUser);
    }

    // UPDATE USER
    @PutMapping("/users/{id}")
    Client putUser(@RequestBody Client userToUpdate, @PathVariable Long id) {
        return userRepository
                .findById(id)
                .map(user -> {
                            user.setName(userToUpdate.getName());
                            user.setSurname(userToUpdate.getSurname());
                            return userRepository.save(user);
                        }
                )
                .orElseGet(() -> {
                    userToUpdate.setId(id);
                    return userRepository.save(userToUpdate);
                });
    }

    @DeleteMapping("/users/{id}")
    void delUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
