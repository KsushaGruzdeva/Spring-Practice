package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Employee;

public interface EmployeeService {
    Optional<Employee> findById (int id);
    void create (Employee employee);
    List<Employee> findAllBySurnameAndNameAndPatronymic (Employee surname, Employee name, Employee patronymic);
}
