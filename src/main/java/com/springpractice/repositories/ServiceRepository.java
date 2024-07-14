package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Service;

public interface ServiceRepository {
    Optional <Service> findById (int id);
    void create (Service service);
    List<Service> findAllByName (Service name);
}
