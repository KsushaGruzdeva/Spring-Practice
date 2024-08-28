package com.springpractice.services;

import java.util.List;

import com.springpractice.dtos.AppointmentDto;
import com.springpractice.dtos.CreateAppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;

public interface AppointmentService {
    AppointmentDto findById (int id);
    List <AppointmentDto> findAll ();
    void create (CreateAppointmentDto appointment);
    void createByService (CreateByServiceAppointment appointment);
    List<AppointmentDto> findAllByClient (Client client);
    List<AppointmentDto> findAllByEmployeeService (EmployeeServices employeeServices);
    List<ServicesDto> recomandation (int clientId);
    Boolean isDiscount (int id);
}
