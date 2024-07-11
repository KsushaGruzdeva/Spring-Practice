package com.springpractice.repositories;

import com.springpractice.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository {
    List<Service> findAllByName (String name);
    List<Service> findAllByPrice (int price);
}
