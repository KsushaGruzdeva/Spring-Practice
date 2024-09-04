package com.springpractice.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.ClientDto;
import com.springpractice.dtos.CreateClientDto;
import com.springpractice.entities.Client;
import com.springpractice.exceptions.ClientNotFoundException;
import com.springpractice.repositories.ClientRepository;
import com.springpractice.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ClientDto findById(int id) {
        Client client = clientRepository.findById(Client.class, id);
        if (client == null){
            throw new ClientNotFoundException(id);
        }
        return mapper.map(client, ClientDto.class);
    }

    @Override
    public ClientDto create(CreateClientDto createClientDto) {
        Client client = mapper.map(createClientDto, Client.class);
        System.out.println(client);
        return mapper.map(clientRepository.create(client), ClientDto.class);
    }

    @Override
    public List<ClientDto> findAll () {
        List <Client> allClients = clientRepository.findAll();
        return allClients.stream().map(client -> mapper.map(client, ClientDto.class)).toList();
    }
}
