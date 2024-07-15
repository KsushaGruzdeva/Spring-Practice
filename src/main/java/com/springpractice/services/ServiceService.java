package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Services;

public interface ServiceService {
    Optional <Services> findById (int id);
    void create (Services service);
    List <Services> findByName (String name);
}
