package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.Client;

public interface ClientRepository {
    List <Client> findAllByName (String name);
    // List<Client> findAll ();
}