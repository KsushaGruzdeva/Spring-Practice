package com.springpractice.repositories;

import java.util.List;

import com.springpractice.entities.Services;

public interface ServiceRepository {
    List <Services> findByName (String name);
    List <Services> findAll ();
    void update (Services services);
}
