package com.springpractice.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.EmployeeServices;
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
    public List<EmployeeServices> findAllByServiceId (int id) {
        return entityManager.createQuery("from EmployeeServices es where es.service.id = :id", EmployeeServices.class)
        .setParameter("id", id)
        .getResultList();
     }
}