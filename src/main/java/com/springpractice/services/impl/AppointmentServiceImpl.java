package com.springpractice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.repositories.AppointmentRepository;
import com.springpractice.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Optional<Appointment> findById(int id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void create(Appointment appointment) {
        appointmentRepository.create(appointment);
    }

    @Override
    public List<Appointment> findAllByClientId (Client id) {
        return appointmentRepository.findAllByClientId(id);
    }

    @Override
    public List<Appointment> findAllByTimeAndDate (Appointment time, Appointment date) {
        return appointmentRepository.findAllByTimeAndDate(time, date);
    }
}
