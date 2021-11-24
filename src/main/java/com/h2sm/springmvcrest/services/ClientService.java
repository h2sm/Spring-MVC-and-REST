package com.h2sm.springmvcrest.services;

import com.h2sm.springmvcrest.entity.Client;
import com.h2sm.springmvcrest.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class ClientService implements BaseService<Client> {
    private final ClientRepository repo;
    @Override
    public List<Client> showAllEntities() {
        return null;
    }

    @Override
    public Client showByID(int id) {
        return null;
    }

    @Override
    public Client showEntityByNamepart(String namepart) {
        return null;
    }

    @Override
    public void insert(Client entity) {

    }

    @Override
    public void modify(Client entity) {

    }

    @Override
    public void delete(Client entity) {

    }
}
