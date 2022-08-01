package ru.company.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.company.devices.entity.Client;
import ru.company.devices.exceptions.ClientNotFoundException;
import ru.company.devices.repository.ClientRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientRepository clientRepo;

    @GetMapping("/clients")
    List<Client> getAll() {
        return clientRepo.findAll();
    }

    @GetMapping("/clients/{id}")
    Client getClient(@PathVariable Long id) {
        return clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @GetMapping("/clients/{name}")
    List<Client> getClientByName(@PathVariable String name) {
        return clientRepo.findByName(name);
    }

    @PostMapping("/clients")
    Client addClient(@RequestBody Client client) {
        return clientRepo.save(client);
    }

    // UPDATE USER
    @PutMapping("/clients/{id}")
    Client putClient(@RequestBody Client clientUpdate, @PathVariable Long id) {
        return clientRepo
                .findById(id)
                .map(client -> {
                    client.setName(clientUpdate.getName());
                    client.setSurname(clientUpdate.getSurname());
                    return clientRepo.save(client);
                })
                .orElseGet(() -> {
                    clientUpdate.setId(id);
                    return clientRepo.save(clientUpdate);
                });
    }

    @DeleteMapping("/clients/{id}")
    void delClient(@PathVariable Long id) {
        clientRepo.deleteById(id);
    }
}
