package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.dtos.CreateServicesDto;
import com.springpractice.dtos.ServicesDto;

public interface ServiceService {
    Optional <ServicesDto> findById (int id);
    ServicesDto create (CreateServicesDto service);
    List <ServicesDto> findByName (String name);
    List <ServicesDto> findAll ();
}
