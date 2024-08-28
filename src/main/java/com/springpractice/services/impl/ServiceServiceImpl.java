package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateServicesDto;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Services;
import com.springpractice.repositories.impl.ServiceRepositoryImpl;
import com.springpractice.services.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private ServiceRepositoryImpl serviceRepository;

    @Override
    public ServicesDto findById(int id) {
        Services services = serviceRepository.findById(Services.class, id);

        return mapper.map(services, ServicesDto.class);
    }

    @Override
    public void create(CreateServicesDto createServicesDto) {
        Services services = mapper.map(createServicesDto, Services.class);
        serviceRepository.create(services);
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

    // @Override
    // public List <ServicesDto> findAll () {
    //     List <Services> services = serviceRepository.findAll();
    //     List<ServicesDto> servicesDtos = new ArrayList<>();
    //     for (int i = 0; i < services.size(); i++) {
    //         servicesDtos.add(mapper.map(services.get(i), ServicesDto.class));
    //     }
    //     return servicesDtos;
    // }
}
