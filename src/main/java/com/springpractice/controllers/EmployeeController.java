package com.springpractice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        Optional<EmployeeDto> employeeOpt = employeeService.findById(id);
        return employeeOpt.get();
    }

    @PostMapping("")
    public EmployeeDto create(@RequestBody CreateEmployeeDto createEmployeeDto){
        return employeeService.create(createEmployeeDto);
    }
    @GetMapping("/byFIO")
    public List <EmployeeDto> findAllBySurnameAndNameAndPatronymic(@RequestParam(name = "surname") String surname, @RequestParam(name = "name") String name, @RequestParam(name = "patronymic") String patronymic){
        List <EmployeeDto> employeeOpt = employeeService.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
        return employeeOpt;
    }

    @GetMapping("")
    public List <EmployeeDto> findAll(){
        List <EmployeeDto> employeeOpt = employeeService.findAll();
        return employeeOpt;
    }
}
