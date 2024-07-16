package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Employee;

public interface EmployeeRepository {
    Optional <Employee> findById (int id);
    Employee create (Employee employee);
    List<Employee> findAll ();
    List <Employee> findAllBySurnameAndNameAndPatronymic (String surname, String name, String patronymic);
}
