package com.springpractice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.entities.Client;
import com.springpractice.repositories.ClientRepository;
import com.springpractice.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public void create(Client employee) {
        clientRepository.create(employee);
    }

    @Override
    public List<Client> findAllByName (Client name) {
        return clientRepository.findAllByName(name);
    }
}
