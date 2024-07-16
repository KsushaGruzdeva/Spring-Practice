package com.springpractice.services;

import java.util.List;
import java.util.Optional;

import com.springpractice.dtos.AppointmentDto;
import com.springpractice.dtos.CreateAppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;

public interface AppointmentService {
    Optional <AppointmentDto> findById (int id);
    List <AppointmentDto> findAll ();
    AppointmentDto create (CreateAppointmentDto appointment);
    AppointmentDto createByService (CreateByServiceAppointment appointment);
    List<AppointmentDto> findAllByClient (Optional <Client> client);
    List<AppointmentDto> findAllByEmployeeService (EmployeeServices employeeServices);
    List<ServicesDto> recomandation (int clientId);
    Boolean isDiscount (int id);
}
