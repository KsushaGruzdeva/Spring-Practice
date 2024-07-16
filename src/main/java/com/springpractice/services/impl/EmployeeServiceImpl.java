package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateEmployeeDto;
import com.springpractice.dtos.EmployeeDto;
import com.springpractice.entities.Employee;
import com.springpractice.repositories.EmployeeRepository;
import com.springpractice.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<EmployeeDto> findById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        return Optional.of(mapper.map(employeeOptional.get(), EmployeeDto.class));
    }

    @Override
    public EmployeeDto create(CreateEmployeeDto createEmployeeDto) {
        Employee employee = mapper.map(createEmployeeDto, Employee.class);
        // System.out.println(employee);
        return mapper.map(employeeRepository.create(employee), EmployeeDto.class);
    }

    @Override
    public List <EmployeeDto> findAllBySurnameAndNameAndPatronymic (String surname, String name, String patronymic) {
        List <Employee> employee = employeeRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
        List<EmployeeDto> employeesDtos = new ArrayList<>();
        for (int i = 0; i < employee.size(); i++) {
                employeesDtos.add(mapper.map(employee.get(i), EmployeeDto.class));
            }
        return employeesDtos;
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
