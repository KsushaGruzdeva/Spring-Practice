package com.springpractice.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpractice.entities.Client;
import com.springpractice.repositories.ClientRepository;

@Repository
public class ClientRepositoryDao implements ClientRepository{
    @Autowired
    private BaseClientRepository baseRepository;

    @Override
    public Optional<Client> findById (int id) {
        return baseRepository.findById(id);
    }

    @Override
    public Client create (Client client) {
        return baseRepository.save(client);
    }

    @Override
    public List <Client> findAllByName (String name) {
        return baseRepository.findAllByName (name);
    }

    @Override
    public List <Client> findAll () {
        return baseRepository.findAll();
    }
}

@Repository
interface BaseClientRepository extends JpaRepository <Client, Integer> {
    @Query(value = "select c from Client c where c.name = :name")
    List <Client> findAllByName (@Param(value = "name") String name);
}
