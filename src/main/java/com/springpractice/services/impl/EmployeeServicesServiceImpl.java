package com.springpractice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.repositories.EmployeeServicesRepository;
import com.springpractice.services.EmployeeServicesService;

@Service
public class EmployeeServicesServiceImpl implements EmployeeServicesService{
    @Autowired
    private EmployeeServicesRepository employeeServicesRepository;

    @Override
    public Optional<EmployeeServices> findById(int id) {
        return employeeServicesRepository.findById(id);
    }

    @Override
    public void create(EmployeeServices employeeServices) {
        employeeServicesRepository.create(employeeServices);
    }

    @Override
    public List<Services> findAllServiceByEmployeeId (Employee id) {
        return employeeServicesRepository.findAllServiceByEmployeeId(id);
    }

    @Override
    public List<Employee> findAllEmployeeByServiceId (Services id) {
        return employeeServicesRepository.findAllEmployeeByServiceId(id);
    }
}
