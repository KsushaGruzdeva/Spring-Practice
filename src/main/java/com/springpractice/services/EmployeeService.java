package com.springpractice.services;

import java.util.List;

import com.springpractice.dtos.CreateEmployeeDto;
import com.springpractice.dtos.EmployeeDto;

public interface EmployeeService {
    EmployeeDto findById (int id);
    List <EmployeeDto> findAll ();
    EmployeeDto create (CreateEmployeeDto employeeDto);
}
