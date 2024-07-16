package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.dtos.CreateEmployeeDto;
import com.springpractice.dtos.EmployeeDto;

public interface EmployeeService {
    Optional<EmployeeDto> findById (int id);
    List <EmployeeDto> findAll ();
    EmployeeDto create (CreateEmployeeDto employeeDto);
    List <EmployeeDto> findAllBySurnameAndNameAndPatronymic (String surname, String name, String patronymic);
}
