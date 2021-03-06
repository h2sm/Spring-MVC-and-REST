package com.h2sm.springmvcrest.repositories;

import com.h2sm.springmvcrest.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findClientByFullNameContaining(String namepart);
}
