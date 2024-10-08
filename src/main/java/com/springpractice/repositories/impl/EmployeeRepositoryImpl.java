package com.springpractice.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Employee;
import com.springpractice.repositories.BaseRepository;
import com.springpractice.repositories.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmployeeRepositoryImpl extends BaseRepository<Employee, Integer> implements EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeRepositoryImpl(){
        super(Employee.class);
    }

    @Override
    public List <Employee> findAll () {
        return entityManager.createQuery("from Employee e", Employee.class)
        .getResultList();
    }
}