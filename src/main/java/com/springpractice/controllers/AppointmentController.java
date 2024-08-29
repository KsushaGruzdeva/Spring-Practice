package com.springpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.dtos.AppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.services.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/{id}")
    public AppointmentDto findById(@PathVariable() int id){
        AppointmentDto appointment = appointmentService.findById(id);
        return appointment;
    }

    @GetMapping("")
    public List<AppointmentDto> findAll(){
        List <AppointmentDto> appointment = appointmentService.findAll();
        return appointment;
    }

    @GetMapping("/isDiscount")
    public boolean isDiscount(@RequestParam(name = "id") int id){
        boolean discount = appointmentService.isDiscount(id);
        return discount;
    }

    @GetMapping("/recomandation")
    public List<ServicesDto> recomandation (@RequestParam(name = "clientId") int clientId){
        List <ServicesDto> services = appointmentService.recomandation(clientId);
        return services;
    }

    @PostMapping("/byService")
    public void createByService(@RequestBody CreateByServiceAppointment createByServiceAppointment){
        appointmentService.createByService(createByServiceAppointment);
    }
}
