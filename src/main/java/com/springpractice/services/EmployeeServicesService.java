package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.dtos.CreateEmployeeServicesDto;
import com.springpractice.dtos.EmployeeDto;
import com.springpractice.dtos.EmployeeServicesDto;
import com.springpractice.dtos.ServicesDto;

public interface EmployeeServicesService {
    Optional <EmployeeServicesDto> findById (int id);
    List <EmployeeServicesDto> findAll ();
    EmployeeServicesDto create (CreateEmployeeServicesDto employee);
    List<ServicesDto> findAllServiceByEmployeeId (int id);
    List<EmployeeDto> findAllEmployeeByServiceId (int id);
    List<EmployeeServicesDto> findAllByServiceId (int id);
}
