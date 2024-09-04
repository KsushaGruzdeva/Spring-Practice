package com.springpractice.services;

import java.util.List;

import com.springpractice.dtos.AppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.DiscountDto;
import com.springpractice.dtos.ServicesDto;

public interface AppointmentService {
    AppointmentDto findById (int id);
    List <AppointmentDto> findAll ();
    AppointmentDto createByService (CreateByServiceAppointment appointment);
    List<ServicesDto> getRecomandation (int clientId);
    List<DiscountDto> hasDiscount (int id);
}
