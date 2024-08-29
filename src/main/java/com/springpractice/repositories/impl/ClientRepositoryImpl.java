package com.springpractice.repositories.impl;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Client;
import com.springpractice.repositories.BaseRepository;
import com.springpractice.repositories.ClientRepository;

@Repository
public class ClientRepositoryImpl extends BaseRepository<Client, Integer> implements ClientRepository{
    // @PersistenceContext
    // private EntityManager entityManager;

    public ClientRepositoryImpl(){
        super(Client.class);
    }
}