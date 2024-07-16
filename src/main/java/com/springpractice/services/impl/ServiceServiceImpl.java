package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateServicesDto;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Services;
import com.springpractice.repositories.ServiceRepository;
import com.springpractice.services.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Optional<ServicesDto> findById(int id) {
        Optional<Services> servicesOptional = serviceRepository.findById(id);

        return Optional.of(mapper.map(servicesOptional.get(), ServicesDto.class));
    }

    @Override
    public ServicesDto create(CreateServicesDto createServicesDto) {
        Services services = mapper.map(createServicesDto, Services.class);
        return mapper.map(serviceRepository.create(services), ServicesDto.class);
    }

    @Override
    public List <ServicesDto> findByName (String name) {
        List <Services> services = serviceRepository.findByName(name);
        List<ServicesDto> servicesDtos = new ArrayList<>();
        for (int i = 0; i < services.size(); i++) {
            servicesDtos.add(mapper.map(services.get(i), ServicesDto.class));
        }
        return servicesDtos;
    }

    @Override
    public List <ServicesDto> findAll () {
        List <Services> services = serviceRepository.findAll();
        List<ServicesDto> servicesDtos = new ArrayList<>();
        for (int i = 0; i < services.size(); i++) {
            servicesDtos.add(mapper.map(services.get(i), ServicesDto.class));
        }
        return servicesDtos;
    }
}
