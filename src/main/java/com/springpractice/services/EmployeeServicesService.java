package com.springpractice.services;

import java.util.List;

import com.springpractice.dtos.CreateEmployeeServicesDto;
import com.springpractice.dtos.EmployeeServicesDto;

public interface EmployeeServicesService {
    EmployeeServicesDto findById (int id);
    List <EmployeeServicesDto> findAll ();
    EmployeeServicesDto create (CreateEmployeeServicesDto employee);
}
