package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.ClientDto;
import com.springpractice.dtos.CreateClientDto;
import com.springpractice.entities.Client;
import com.springpractice.repositories.impl.ClientRepositoryImpl;
import com.springpractice.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @Override
    public ClientDto findById(int id) {
        Client client = clientRepository.findById(Client.class, id);

        return mapper.map(client, ClientDto.class);
    }

    @Override
    public void create(CreateClientDto createClientDto) {
        Client client = mapper.map(createClientDto, Client.class);
        System.out.println(client);
        clientRepository.create(client);
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

    // @Override
    // public List<ClientDto> findAll () {
    //     List <Client> client = clientRepository.findAll();
    //     List<ClientDto> clientDtos = new ArrayList<>();
    //     for (int i = 0; i < client.size(); i++) {
    //         clientDtos.add(mapper.map(client.get(i), ClientDto.class));
    //     }
    //     return clientDtos;
    // }
}
