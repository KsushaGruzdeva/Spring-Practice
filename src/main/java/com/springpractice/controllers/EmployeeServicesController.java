package com.springpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.dtos.CreateEmployeeServicesDto;
import com.springpractice.dtos.EmployeeServicesDto;
import com.springpractice.services.EmployeeServicesService;

@RestController
@RequestMapping("/api/employeeServices")
public class EmployeeServicesController {
    @Autowired
    private EmployeeServicesService employeeServicesService;

    @GetMapping("/{id}")
    public EmployeeServicesDto findById(@PathVariable() int id){
        EmployeeServicesDto employeeServices = employeeServicesService.findById(id);
        return employeeServices;
    }

    @GetMapping("")
    public List <EmployeeServicesDto> findAll(){
        List <EmployeeServicesDto> employeeServices = employeeServicesService.findAll();
        return employeeServices;
    }

    @PostMapping("")
    public EmployeeServicesDto  create(@RequestBody CreateEmployeeServicesDto createEmployeeServicesDto){
        return employeeServicesService.create(createEmployeeServicesDto);
    }
}
