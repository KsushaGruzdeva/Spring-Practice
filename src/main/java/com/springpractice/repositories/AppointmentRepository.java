package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;

@Repository
public interface AppointmentRepository{
    Optional <Appointment> findById (int id);
    void create (Appointment client);
    List<Appointment> findAllByClientId (Client id);
    List<Appointment> findAllByTimeAndDate (Appointment time, Appointment date);
}
