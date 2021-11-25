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

    @GetMapping("/find/{id}")
    public Client findById(@PathVariable("id") int id) {
        return service.showByID(id);
    }

    @GetMapping("/find-all")
    public List<Client> findAll() {
        return service.showAllEntities();
    }

    @GetMapping("/find-namepart/{namepart}")
    public Client findByNamePart(@PathVariable String namepart){
        return service.findByNamepart(namepart);
    }

    @PostMapping( "/add-cli")// test req - /add-cli?fullName=hello&passport=0101%20222111&phoneNumber=01&date_of_bith=01-02-1992
    public Client addClient(Client client) {
        service.insert(client);
        return client;
    }
    @PostMapping( "/delete/{id}")
    public String deleteClient(@PathVariable("id") int id){
        service.delete(id);
        return "client with id " + id + " was deleted";
    }
    @PostMapping( "/modify/{id}")//POST http://localhost:8080/modify/2?fullName=testClient2&passport=0123%666666&phoneNumber=911&dateOfBirth=14-05-2010
    public Client modifyClient(@PathVariable("id") int id, Client client){
        service.modify(client);
        return client;
    }
}
