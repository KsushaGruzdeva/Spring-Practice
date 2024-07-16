package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Client;

public interface ClientRepository {
    Optional <Client> findById (int id);
    Client create (Client client);
    List <Client> findAllByName (String name);
    List<Client> findAll ();
}