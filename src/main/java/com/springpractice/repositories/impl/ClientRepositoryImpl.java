package com.springpractice.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Client;
import com.springpractice.repositories.BaseRepository;
import com.springpractice.repositories.ClientRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClientRepositoryImpl extends BaseRepository<Client, Integer> implements ClientRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public ClientRepositoryImpl(){
        super(Client.class);
    }

    @Override
    public List <Client> findAll () {
        return entityManager.createQuery("from Client c", Client.class)
        .getResultList();
    }
}