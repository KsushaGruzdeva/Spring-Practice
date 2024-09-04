package com.springpractice.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Services;
import com.springpractice.repositories.BaseRepository;
import com.springpractice.repositories.ServiceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ServiceRepositoryImpl extends BaseRepository<Services, Integer> implements ServiceRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public ServiceRepositoryImpl(){
        super(Services.class);
    }

    @Override
    public List <Services> findByName (String name) {
        return entityManager.createQuery("from Services s where s.name = :name", Services.class)
        .setParameter("name", name)
        .getResultList();
    }

    @Override
    public List <Services> findAll () {
        return entityManager.createQuery("from Services s", Services.class)
        .getResultList();
    }
}