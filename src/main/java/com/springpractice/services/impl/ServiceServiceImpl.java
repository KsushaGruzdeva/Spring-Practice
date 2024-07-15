package com.springpractice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.entities.Services;
import com.springpractice.repositories.ServiceRepository;
import com.springpractice.services.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Optional<Services> findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void create(Services employee) {
        serviceRepository.create(employee);
    }

    @Override
    public List <Services> findByName (String name) {
        return serviceRepository.findByName(name);
    }
}
