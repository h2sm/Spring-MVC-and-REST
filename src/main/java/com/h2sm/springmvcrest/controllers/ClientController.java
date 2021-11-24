package com.h2sm.springmvcrest.controllers;

import com.h2sm.springmvcrest.entity.Client;
import com.h2sm.springmvcrest.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClientController {
    private final ClientService service;

    @GetMapping("/find/{id:\\d+}")
    public Client findById(@PathVariable int id) {
        return service.showByID(id);
    }

    @GetMapping("/find-all")
    public List<Client> findAll() {
        return service.showAllEntities();
    }

    @RequestMapping(value = "/add-cli", params = {"fullName", "passport", "phoneNumber", "date_of_birth"})
    public @ResponseBody Client addClient(@RequestBody Client client) {
        service.insert(client);
        return client;
    }


}
