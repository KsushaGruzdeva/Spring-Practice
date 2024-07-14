package com.springpractice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.entities.Employee;
import com.springpractice.repositories.EmployeeRepository;
import com.springpractice.services.EmployeeService;

@Service
public class EmployeeDomainServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }

    @Override
    public List<Employee> findAllBySurnameAndNameAndPatronymic (Employee surname, Employee name, Employee patronymic) {
        return employeeRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }
}
