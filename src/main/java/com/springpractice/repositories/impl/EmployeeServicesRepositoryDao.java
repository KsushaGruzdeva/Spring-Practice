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
    public EmployeeServices create (EmployeeServices employeeServices) {
        return baseRepository.save(employeeServices);
    }

    @Override
    public List<Services> findAllServiceByEmployeeId (int id) {
        return baseRepository.findAllServiceByEmployeeId(id);
    }

    @Override
    public List<Employee> findAllEmployeeByServiceId (int id) {
        return baseRepository.findAllEmployeeByServiceId(id);
    }

    @Override
    public List<EmployeeServices> findAllByServiceId (int id) {
        return baseRepository.findAllByServiceId(id);
    }

    @Override
    public List <EmployeeServices> findAll () {
        return baseRepository.findAll();
    }
}

@Repository
interface BaseEmployeeServicesRepository extends JpaRepository <EmployeeServices, Integer> {
    @Query(value = "select es.service from EmployeeServices es join es.employee e where e.id = :id")
    List<Services> findAllServiceByEmployeeId (@Param(value = "id") int id);

    @Query(value = "select es.employee from EmployeeServices es join es.service s where s.id = :id")
    List<Employee> findAllEmployeeByServiceId (@Param(value = "id") int id);

    @Query(value = "select es from EmployeeServices es join es.service s where s.id = :id")
    List<EmployeeServices> findAllByServiceId (@Param(value = "id") int id);
}