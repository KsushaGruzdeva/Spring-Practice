package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;

public interface AppointmentService {
    Optional <Appointment> findById (int id);
    void create (Appointment client);
    List<Appointment> findAllByClientId (Client id);
    List<Appointment> findAllByTimeAndDate (Appointment time, Appointment date);
}
