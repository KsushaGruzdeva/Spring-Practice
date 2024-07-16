package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.dtos.ClientDto;
import com.springpractice.dtos.CreateClientDto;

public interface  ClientService {
    Optional <ClientDto> findById (int id);
    List <ClientDto> findAll ();
    ClientDto create (CreateClientDto clientDto);
    List <ClientDto> findAllByName (String name);
}
