package com.h2sm.springmvcrest.controllers;

import com.h2sm.springmvcrest.entity.Client;
import com.h2sm.springmvcrest.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ClientController {
    private final ClientService service;

    @GetMapping("/find/{id:\\d+}")
    public Client findById(@PathVariable int id) {
        return service.showByID(id);
    }
}
