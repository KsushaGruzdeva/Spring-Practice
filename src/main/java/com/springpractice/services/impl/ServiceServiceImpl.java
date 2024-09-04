package com.springpractice.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateServicesDto;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Services;
import com.springpractice.exceptions.ServiceNotFoundException;
import com.springpractice.repositories.ServiceRepository;
import com.springpractice.services.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ServicesDto findById(int id) {
        Services services = serviceRepository.findById(Services.class, id);
        if (services == null)
            throw new ServiceNotFoundException(id);
        return mapper.map(services, ServicesDto.class);
    }

    @Override
    public ServicesDto create(CreateServicesDto createServicesDto) {
        Services services = mapper.map(createServicesDto, Services.class);
        // serviceRepository.create(services);
        return mapper.map(serviceRepository.create(services), ServicesDto.class);
    }

    @Override
    public List <ServicesDto> findAll () {
        List <Services> allServices = serviceRepository.findAll();
        return allServices.stream().map(services -> mapper.map(services, ServicesDto.class)).toList();
    }
}
