package com.springpractice.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springpractice.entities.Services;
import com.springpractice.repositories.ServiceRepository;

@Repository
public class ServiceRepositoryDao implements ServiceRepository{
    @Autowired
    private BaseServiceRepository baseRepository;

    @Override
    public Optional<Services> findById(int id) {
        return baseRepository.findById(id);
    }

    @Override
    public void create (Services service) {
        baseRepository.save(service);
    }

    @Override
    public List <Services> findByName (String name) {
        return baseRepository.findByName(name);
    }
}

@Repository
interface BaseServiceRepository extends JpaRepository <Services, Integer> {

    // List<Student> findAllByGroupName(String groupName);
    // @Query(value = "select s from Service s where s.name = :name")
    List<Services> findByName (String name);
}