package com.springpractice.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.repositories.AppointmentRepository;
import com.springpractice.repositories.BaseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class AppointmentRepositoryImpl extends BaseRepository<Appointment, Integer> implements AppointmentRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public AppointmentRepositoryImpl(){
        super(Appointment.class);
    }

    @Override
    public List<Appointment> findAllByClient (Client client) {
        return entityManager.createQuery("from Appointment a where a.client = :client", Appointment.class)
        .setParameter("client", client)
        .getResultList();
    }

    @Override
    public List<Appointment> findAllByEmployeeService (EmployeeServices employeeServices) {
        return entityManager.createQuery("from Appointment a where a.employeeServices = :employeeServices", Appointment.class)
        .setParameter("employeeServices", employeeServices)
        .getResultList();
    }

    @Override
    public List <Appointment> findAll () {
        return entityManager.createQuery("from Appointment a", Appointment.class)
        .getResultList();
    }
}
