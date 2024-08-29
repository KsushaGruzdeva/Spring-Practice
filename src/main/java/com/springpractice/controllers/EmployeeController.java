package com.springpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.dtos.CreateEmployeeDto;
import com.springpractice.dtos.EmployeeDto;
import com.springpractice.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable() int id){
        EmployeeDto employee = employeeService.findById(id);
        return employee;
    }

    @PostMapping("")
    public void create(@RequestBody CreateEmployeeDto createEmployeeDto){
        employeeService.create(createEmployeeDto);
    }

    @GetMapping("")
    public List <EmployeeDto> findAll(){
        List <EmployeeDto> employeeOpt = employeeService.findAll();
        return employeeOpt;
    }
}
