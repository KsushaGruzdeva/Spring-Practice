package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;

public interface EmployeeServicesService {
    Optional <EmployeeServices> findById (int id);
    void create (EmployeeServices employee);
    List<Services> findAllServiceByEmployeeId (Employee id);
    List<Employee> findAllEmployeeByServiceId (Services id);
}
