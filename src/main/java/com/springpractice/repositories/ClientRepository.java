package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.Client;

public interface ClientRepository {
    List <Client> findAll ();
    Client findById(Class<Client> clientClass, int id);
    Client create (Client client);
}