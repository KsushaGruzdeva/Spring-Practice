package com.springpractice.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateEmployeeServicesDto;
import com.springpractice.dtos.EmployeeServicesDto;
import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.exceptions.EmployeeNotFoundException;
import com.springpractice.exceptions.EmployeeServicesNotFoundException;
import com.springpractice.exceptions.ServiceNotFoundException;
import com.springpractice.repositories.EmployeeRepository;
import com.springpractice.repositories.EmployeeServicesRepository;
import com.springpractice.repositories.ServiceRepository;
import com.springpractice.services.EmployeeServicesService;

@Service
public class EmployeeServicesServiceImpl implements EmployeeServicesService{
    @Autowired
    private EmployeeServicesRepository employeeServicesRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public EmployeeServicesDto findById(int id) {
        EmployeeServices employeeServices = employeeServicesRepository.findById(EmployeeServices.class, id);
        if (employeeServices == null){
            throw new EmployeeServicesNotFoundException(id);
        }
        return mapper.map(employeeServices, EmployeeServicesDto.class);
    }

    @Override
    public EmployeeServicesDto create(CreateEmployeeServicesDto createEmployeeServicesDto) {
        Employee employee = employeeRepository.findById(Employee.class, createEmployeeServicesDto.getEmployeeId());
        if (employee == null){
            throw new EmployeeNotFoundException(createEmployeeServicesDto.getEmployeeId());
        }
        Services service = serviceRepository.findById(Services.class, createEmployeeServicesDto.getServiceId());
        if (service == null){
            throw new ServiceNotFoundException(createEmployeeServicesDto.getServiceId());
        }

        EmployeeServices employeeServices = new EmployeeServices(employee, service);
        // employeeServicesRepository.create(employeeServices);
        return mapper.map(employeeServicesRepository.create(employeeServices), EmployeeServicesDto.class);
    }

    @Override
    public List<EmployeeServicesDto> findAll () {
        List<EmployeeServices> allEmployeeServices = employeeServicesRepository.findAll();
        return allEmployeeServices.stream().map(employeeServices -> mapper.map(employeeServices, EmployeeServicesDto.class)).toList();
    }
}
