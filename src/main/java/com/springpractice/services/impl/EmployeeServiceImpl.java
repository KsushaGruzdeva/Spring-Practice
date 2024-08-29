package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateEmployeeDto;
import com.springpractice.dtos.EmployeeDto;
import com.springpractice.entities.Employee;
import com.springpractice.repositories.impl.EmployeeRepositoryImpl;
import com.springpractice.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;

    @Override
    public EmployeeDto findById(int id) {
        Employee employee = employeeRepository.findById(Employee.class, id);

        return mapper.map(employee, EmployeeDto.class);
    }

    @Override
    public void create(CreateEmployeeDto createEmployeeDto) {
        Employee employee = mapper.map(createEmployeeDto, Employee.class);
        // System.out.println(employee);
        employeeRepository.create(employee);
    }

    @Override
    public List <EmployeeDto> findAll () {
        List <Employee> employee = employeeRepository.findAll();
        List<EmployeeDto> employeesDtos = new ArrayList<>();
        for (int i = 0; i < employee.size(); i++) {
                employeesDtos.add(mapper.map(employee.get(i), EmployeeDto.class));
            }
        return employeesDtos;
    }
}
