package com.springpractice.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;

@Repository
public class EmployeeServicesRepositoryDao implements com.springpractice.repositories.EmployeeServicesRepository{
    @Autowired
    private BaseEmployeeServicesRepository baseRepository;

    @Override
    public Optional<EmployeeServices> findById(int id) {
        return baseRepository.findById(id);
    }

    @Override
    public void create (EmployeeServices employeeServices) {
        baseRepository.save(employeeServices);
    }

    @Override
    public List<Services> findAllServiceByEmployeeId (Employee id) {
        return baseRepository.findAllServiceByEmployeeId(id);
    }

    @Override
    public List<Employee> findAllEmployeeByServiceId (Services id) {
        return baseRepository.findAllEmployeeByServiceId(id);
    }
}

@Repository
interface BaseEmployeeServicesRepository extends JpaRepository <EmployeeServices, Integer> {
    @Query(value = "select es.service from EmployeeServices es join es.employee e where e.id = :id")
    List<Services> findAllServiceByEmployeeId (@Param(value = "id") Employee id);

    @Query(value = "select es.employee from EmployeeServices es join es.service s where s.id = :id")
    List<Employee> findAllEmployeeByServiceId (@Param(value = "id") Services id);
}