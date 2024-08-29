package com.springpractice.repositories.impl;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Employee;
import com.springpractice.repositories.BaseRepository;
import com.springpractice.repositories.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl extends BaseRepository<Employee, Integer> implements EmployeeRepository {
    // @PersistenceContext
    // private EntityManager entityManager;

    public EmployeeRepositoryImpl(){
        super(Employee.class);
    }
}