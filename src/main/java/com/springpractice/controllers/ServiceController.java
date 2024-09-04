package com.springpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.dtos.CreateServicesDto;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.services.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    private ServiceService servicesService;

    @GetMapping("/{id}")
    public ServicesDto findById(@PathVariable() int id){
        ServicesDto services = servicesService.findById(id);
        return services;
    }

    @PostMapping("")
    public ServicesDto create(@RequestBody CreateServicesDto createServicesDto){
        return servicesService.create(createServicesDto);
    }

    @GetMapping("")
    public List <ServicesDto> findAll(){
        List <ServicesDto> services = servicesService.findAll();
        return services;
    }
}
