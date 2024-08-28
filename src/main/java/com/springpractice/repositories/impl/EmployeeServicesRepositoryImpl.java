package com.springpractice.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.repositories.BaseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmployeeServicesRepositoryImpl extends BaseRepository<EmployeeServices, Integer> implements com.springpractice.repositories.EmployeeServicesRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeServicesRepositoryImpl(){
        super(EmployeeServices.class);
    }

    @Override
    public List<Services> findAllServiceByEmployeeId (int id) {
        return entityManager.createQuery("from EmployeeServices.service es where es.employee.id = :id", Services.class)
        .setParameter("id", id)
        .getResultList();
    }

    @Override
    public List<Employee> findAllEmployeeByServiceId (int id) {
        return entityManager.createQuery("from EmployeeServices.employee es where es.service.id = :id", Employee.class)
        .setParameter("id", id)
        .getResultList();
    }

    @Override
    public List<EmployeeServices> findAllByServiceId (int id) {
        return entityManager.createQuery("from EmployeeServices es where es.service.id = :id", EmployeeServices.class)
        .setParameter("id", id)
        .getResultList();
     }

    // @Override
    // public List <EmployeeServices> findAll () {
    //     return baseRepository.findAll();
    // }
}