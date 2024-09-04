package com.springpractice.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateEmployeeDto;
import com.springpractice.dtos.EmployeeDto;
import com.springpractice.entities.Employee;
import com.springpractice.exceptions.EmployeeNotFoundException;
import com.springpractice.repositories.EmployeeRepository;
import com.springpractice.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public EmployeeDto findById(int id) {
        Employee employee = employeeRepository.findById(Employee.class, id);
        if (employee == null){
            throw new EmployeeNotFoundException(id);
        }
        return mapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto create(CreateEmployeeDto createEmployeeDto) {
        Employee employee = mapper.map(createEmployeeDto, Employee.class);
        // employeeRepository.create(employee);
        return mapper.map(employeeRepository.create(employee), EmployeeDto.class);
    }

    @Override
    public List <EmployeeDto> findAll () {
        List <Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(employee -> mapper.map(employee, EmployeeDto.class)).toList();
    }
}
