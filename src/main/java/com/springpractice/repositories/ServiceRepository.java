package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.Services;

public interface ServiceRepository {
    List <Services> findAll ();
    Services findById(Class<Services> servicesClass, int id);
    Services create (Services services);
    List <Services> findByName (String name);
}
