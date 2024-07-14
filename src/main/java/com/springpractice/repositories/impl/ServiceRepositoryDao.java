package com.springpractice.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpractice.entities.Service;
import com.springpractice.repositories.ServiceRepository;

@Repository
public class ServiceRepositoryDao implements ServiceRepository{
    @Autowired
    private BaseServiceRepository baseRepository;

    @Override
    public Optional<Service> findById(int id) {
        return baseRepository.findById(id);
    }

    @Override
    public void create (Service service) {
        baseRepository.save(service);
    }

    @Override
    public List<Service> findAllByName (Service name) {
        return baseRepository.findAllByName(name);
    }
}

@Repository
interface BaseServiceRepository extends JpaRepository <Service, Integer> {
    @Query(value = "select s from Service s where s.name = :name")
    List<Service> findAllByName (@Param(value = "name") Service name);
}