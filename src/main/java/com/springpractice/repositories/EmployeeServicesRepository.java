package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.EmployeeServices;

public interface EmployeeServicesRepository {
    List <EmployeeServices> findAll ();
    EmployeeServices findById(Class<EmployeeServices> employeeServicesClass, int id);
    EmployeeServices create (EmployeeServices employeeServices);
    List<EmployeeServices> findAllByServiceId (int id);
}
