package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.Employee;

public interface EmployeeRepository {
    // List<Employee> findAll ();
    List <Employee> findAllBySurnameAndNameAndPatronymic (String surname, String name, String patronymic);
}
