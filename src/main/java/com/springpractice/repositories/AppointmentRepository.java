package com.springpractice.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;

@Repository
public interface AppointmentRepository{
    List<Appointment> findAllByClient (Client client);
    List<Appointment> findAllByEmployeeService (EmployeeServices employeeServices);
}
