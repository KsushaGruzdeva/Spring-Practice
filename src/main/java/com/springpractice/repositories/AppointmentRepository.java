package com.springpractice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;

@Repository
public interface AppointmentRepository{
    Optional <Appointment> findById (int id);
    Appointment create (Appointment appointment);
    List<Appointment> findAllByClient (Optional <Client> client);
    List<Appointment> findAllByEmployeeService (EmployeeServices employeeServices);
    List<Appointment> findAll ();
}
