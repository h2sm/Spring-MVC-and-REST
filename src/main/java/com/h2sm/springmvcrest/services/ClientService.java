package com.h2sm.springmvcrest.services;

import com.h2sm.springmvcrest.entity.Client;
import com.h2sm.springmvcrest.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements BaseService<Client> {
    private final ClientRepository repo;

    @Override
    @Transactional
    public List<Client> showAllEntities() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public Client showByID(int id) {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public Client findByNamepart(String namepart) {
        return null;
    }

    @Override
    @Transactional
    public void insert(Client entity) {
        repo.save(entity);
    }

    @Override
    @Transactional
    public void modify(Client entity) {
        if (repo.existsById(entity.getId())) insert(entity);
        else throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public void delete(int id) {
        if (repo.existsById(id)) repo.delete(showByID(id));
        else throw new EntityNotFoundException();
    }
}
