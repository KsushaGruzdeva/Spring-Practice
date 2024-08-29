package com.springpractice.services;

import java.util.List;

import com.springpractice.dtos.CreateServicesDto;
import com.springpractice.dtos.ServicesDto;

public interface ServiceService {
    ServicesDto findById (int id);
    void create (CreateServicesDto service);
    List <ServicesDto> findAll ();
}
