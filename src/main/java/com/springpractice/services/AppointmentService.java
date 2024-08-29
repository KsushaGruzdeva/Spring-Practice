package com.springpractice.services;

import java.util.List;

import com.springpractice.dtos.AppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.ServicesDto;

public interface AppointmentService {
    AppointmentDto findById (int id);
    List <AppointmentDto> findAll ();
    void createByService (CreateByServiceAppointment appointment);
    List<ServicesDto> recomandation (int clientId);
    Boolean isDiscount (int id);
}
