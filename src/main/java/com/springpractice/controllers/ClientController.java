package com.springpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.dtos.ClientDto;
import com.springpractice.dtos.CreateClientDto;
import com.springpractice.services.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ClientDto findById(@PathVariable() int id){
        ClientDto client = clientService.findById(id);
        return client;
    }

    @PostMapping("")
    public void create(@RequestBody CreateClientDto createClientDto){
        clientService.create(createClientDto);
    }

    @GetMapping("/byName")
    public List <ClientDto> findAllByName(@RequestParam(name = "name") String name){
        List <ClientDto> clientOpt = clientService.findAllByName(name);
        return clientOpt;
    }

    // @GetMapping("")
    // public List <ClientDto> findAll(){
    //     List <ClientDto> clientOpt = clientService.findAll();
    //     return clientOpt;
    // }
}
