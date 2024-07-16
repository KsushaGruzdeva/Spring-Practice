package com.springpractice.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.repositories.AppointmentRepository;

@Repository
public class AppointmentRepositoryDao implements AppointmentRepository{
    @Autowired
    private BaseAppointmentRepository baseRepository;

    @Override
    public Optional<Appointment> findById (int id) {
        return baseRepository.findById(id);
    }

    @Override
    public Appointment create (Appointment appointment) {
        return baseRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAllByClient (Optional <Client> client) {
        return baseRepository.findAllByClient (client);
    }

    @Override
    public List<Appointment> findAllByEmployeeService (EmployeeServices employeeServices) {
        return baseRepository.findAllByEmployeeService (employeeServices);
    }

    @Override
    public List <Appointment> findAll () {
        return baseRepository.findAll();
    }
}

@Repository
interface BaseAppointmentRepository extends JpaRepository<Appointment, Integer> {
    //Search all appointments for one client by his id
    @Query(value = "select a from Appointment a where a.client = :client")
    List<Appointment> findAllByClient (@Param(value = "client") Optional <Client> client);

    @Query(value = "select a from Appointment a where a.employeeServices = :employeeServices")
    List<Appointment> findAllByEmployeeService (@Param(value = "employeeServices") EmployeeServices employeeServices);
}
