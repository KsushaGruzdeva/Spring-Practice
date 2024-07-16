package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;

public interface EmployeeServicesRepository {
    Optional <EmployeeServices> findById (int id);
    EmployeeServices create (EmployeeServices employee);
    List<Services> findAllServiceByEmployeeId (int id);
    List<Employee> findAllEmployeeByServiceId (int id);
    List<EmployeeServices> findAllByServiceId (int id);
    List<EmployeeServices> findAll ();
}
