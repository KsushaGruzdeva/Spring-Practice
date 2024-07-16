package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Services;

public interface ServiceRepository {
    Optional <Services> findById (int id);
    Services create (Services service);
    List <Services> findByName (String name);
    List <Services> findAll ();

}
