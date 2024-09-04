package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.Employee;

public interface EmployeeRepository {
    List<Employee> findAll ();
    Employee findById(Class<Employee> employeeClass, int id);
    Employee create (Employee employee);
}
