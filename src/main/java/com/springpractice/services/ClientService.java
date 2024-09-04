package com.springpractice.services;

import java.util.List;

import com.springpractice.dtos.ClientDto;
import com.springpractice.dtos.CreateClientDto;

public interface  ClientService {
    ClientDto findById (int id);
    List <ClientDto> findAll ();
    ClientDto create (CreateClientDto clientDto);
}
