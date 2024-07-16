package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.ClientDto;
import com.springpractice.dtos.CreateClientDto;
import com.springpractice.entities.Client;
import com.springpractice.repositories.ClientRepository;
import com.springpractice.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Optional<ClientDto> findById(int id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        return Optional.of(mapper.map(clientOptional.get(), ClientDto.class));
    }

    @Override
    public ClientDto create(CreateClientDto createClientDto) {
        Client client = mapper.map(createClientDto, Client.class);
        System.out.println(client);
        return mapper.map(clientRepository.create(client), ClientDto.class);
    }

    @Override
    public List<ClientDto> findAllByName (String name) {
        List <Client> client = clientRepository.findAllByName(name);
        List<ClientDto> clientDtos = new ArrayList<>();
        for (int i = 0; i < client.size(); i++) {
            clientDtos.add(mapper.map(client.get(i), ClientDto.class));
        }
        return clientDtos;
    }

    @Override
    public List<ClientDto> findAll () {
        List <Client> client = clientRepository.findAll();
        List<ClientDto> clientDtos = new ArrayList<>();
        for (int i = 0; i < client.size(); i++) {
            clientDtos.add(mapper.map(client.get(i), ClientDto.class));
        }
        return clientDtos;
    }
}
