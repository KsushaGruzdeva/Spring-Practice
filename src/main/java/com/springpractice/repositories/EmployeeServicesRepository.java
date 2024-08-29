package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.EmployeeServices;

public interface EmployeeServicesRepository {
    List<EmployeeServices> findAllByServiceId (int id);
    List <EmployeeServices> findAll ();
}
