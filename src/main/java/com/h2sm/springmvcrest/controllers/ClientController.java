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

    @RequestMapping( "/add-cli")// test req - /add-cli?name=hello&passport=0101%20222111&phone=01&date=01-02-1992
    public String addClient(@RequestParam("name") String name,
                            @RequestParam("passport") String pass,
                            @RequestParam("phone") String phone,
                            @RequestParam("date") String date) {
        service.insert(new Client(name,pass,phone, date));
        return "added";
    }
    @PostMapping(value = "/delete/{id:\\d+}")
    public String deleteClient(@RequestParam("id") int id){
        service.delete(id);
        return "deleted";
    }
    @PostMapping(value = "modify/{id:\\d+}")
    public Client modifyClient(int id){
        service.modify(service.showByID(id));
        return service.showByID(id);
    }



}
