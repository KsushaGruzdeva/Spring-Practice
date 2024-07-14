package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Service;

public interface EmployeeServicesRepository {
    Optional <EmployeeServices> findById (int id);
    void create (EmployeeServices employee);
    List<Service> findAllServiceByEmployeeId (Employee id);
    List<Employee> findAllEmployeeByServiceId (Service id);
}
