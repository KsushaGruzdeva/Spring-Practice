package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Client;

public interface  ClientService {
    Optional <Client> findById (int id);
    void create (Client client);
    List <Client> findAllByName (Client name);
}
