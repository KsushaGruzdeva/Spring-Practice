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
    public List <Client> findAllByName (String name) {
        return entityManager.createQuery("from Client c where c.name = :name", Client.class)
        .setParameter("name", name)
        .getResultList();
    }

    // @Override
    // public List <Client> findAll () {
    //     return baseRepository.findAll();
    // }
}