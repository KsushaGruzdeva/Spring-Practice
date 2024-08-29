package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.CreateEmployeeServicesDto;
import com.springpractice.dtos.EmployeeServicesDto;
import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.repositories.impl.EmployeeRepositoryImpl;
import com.springpractice.repositories.impl.EmployeeServicesRepositoryImpl;
import com.springpractice.repositories.impl.ServiceRepositoryImpl;
import com.springpractice.services.EmployeeServicesService;

@Service
public class EmployeeServicesServiceImpl implements EmployeeServicesService{
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private EmployeeServicesRepositoryImpl employeeServicesRepository;

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;

    @Autowired
    private ServiceRepositoryImpl serviceRepository;

    @Override
    public EmployeeServicesDto findById(int id) {
        EmployeeServices employeeServices = employeeServicesRepository.findById(EmployeeServices.class, id);
        return mapper.map(employeeServices, EmployeeServicesDto.class);
    }

    @Override
    public void create(CreateEmployeeServicesDto createEmployeeServicesDto) {
        Employee employee = employeeRepository.findById(Employee.class, createEmployeeServicesDto.getEmployeeId());
        // if (employee.isEmpty())
        //     System.out.println(createEmployeeServicesDto.getEmployeeId());
        Services service = serviceRepository.findById(Services.class, createEmployeeServicesDto.getServiceId());

        EmployeeServices employeeServices = new EmployeeServices(employee, service);
        employeeServicesRepository.create(employeeServices);
    }

    @Override
    public List<EmployeeServicesDto> findAll () {
        List<EmployeeServices> employeeServices = employeeServicesRepository.findAll(EmployeeServices.class);
        List<EmployeeServicesDto> employeesServicesDtos = new ArrayList<>();
        for (int i = 0; i < employeeServices.size(); i++) {
            employeesServicesDtos.add(mapper.map(employeeServices.get(i), EmployeeServicesDto.class));
        }
        return employeesServicesDtos;
    }
}
