package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.AppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.DiscountDto;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.exceptions.AppointmentNotCreateException;
import com.springpractice.exceptions.AppointmentNotFoundException;
import com.springpractice.exceptions.ClientNotFoundException;
import com.springpractice.exceptions.ServiceNotFoundException;
import com.springpractice.repositories.AppointmentRepository;
import com.springpractice.repositories.ClientRepository;
import com.springpractice.repositories.EmployeeServicesRepository;
import com.springpractice.repositories.ServiceRepository;
import com.springpractice.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private EmployeeServicesRepository employeeServicesRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AppointmentDto findById(int id) {
        Appointment appointment = appointmentRepository.findById(Appointment.class, id);
        if (appointment == null){
            throw new AppointmentNotFoundException(id);
        }
        return mapper.map(appointment, AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> findAll () {
        List <Appointment> allAppointments = appointmentRepository.findAll();
        return allAppointments.stream().map(appointment -> mapper.map(appointment, AppointmentDto.class)).toList();

    }

    @Override
    public List<DiscountDto> hasDiscount (int id){
        Client client = clientRepository.findById(Client.class, id);
        if (client == null){
            throw new ClientNotFoundException(id);
        }
        List <Appointment> appointments = appointmentRepository.findAllByClient(client);
        List<DiscountDto> discountDtos = new ArrayList<>();
        if (appointments.isEmpty()){
            discountDtos.add(new DiscountDto("first visit", 50));
        }
        else if ((appointments.size() + 1) % 5 == 0){
            discountDtos.add(new DiscountDto("frequent customer", 15));
        }
        return discountDtos;
    }

    @Override
    public AppointmentDto createByService (CreateByServiceAppointment createByServiceAppointmentDto) {
        Client client = clientRepository.findById(Client.class, createByServiceAppointmentDto.getClientId());
        if (client == null){
            throw new ClientNotFoundException(createByServiceAppointmentDto.getClientId());
        }
        System.out.println(createByServiceAppointmentDto.getClientId());
        Services services = serviceRepository.findById(Services.class, createByServiceAppointmentDto.getServicesId());
        if (services == null){
            throw new ServiceNotFoundException(createByServiceAppointmentDto.getServicesId());
        }
        System.out.println(services.getId());
        List <EmployeeServices> employeeServices = employeeServicesRepository.findAllByServiceId(services.getId());

        List <Appointment> allAppointment = new ArrayList<>();

        for (int i = 0; i < employeeServices.size(); i++) {
            List <Appointment> appointmentByEmployeeService = appointmentRepository.findAllByEmployeeService(employeeServices.get(i));
            for (int j = 0; j < appointmentByEmployeeService.size(); j++) {
                if (appointmentByEmployeeService.get(j).getDate().getTime() == createByServiceAppointmentDto.getDate().getTime()){
                    allAppointment.add(appointmentByEmployeeService.get(j));
                }
            }
        }

        List <EmployeeServices> employeeServicesBlocked = new ArrayList<>();
        for (int i = 0; i < allAppointment.size(); i++) {
            employeeServicesBlocked.add(allAppointment.get(i).getEmployeeServices());
        }

        for (int i = 0; i < employeeServicesBlocked.size(); i++) {
            employeeServices.remove(employeeServicesBlocked.get(i));
        }

        if (employeeServices.isEmpty()){
            throw new AppointmentNotCreateException();
        }

        Appointment appointment = new Appointment(createByServiceAppointmentDto.getDate(), client, employeeServices.get(0));
        // appointmentRepository.create(appointment);
        return mapper.map(appointmentRepository.create(appointment), AppointmentDto.class);
    }

    @Override
    public List<ServicesDto> getRecomandation (int clientId) {
        Client client = clientRepository.findById(Client.class, clientId);
        if (client == null){
            throw new ClientNotFoundException(clientId);
        }
        List <Appointment> appointment = appointmentRepository.findAllByClient(client);
        List <Services> services = new ArrayList<>();
        if (appointment.isEmpty()){
            List <Appointment> allAppointment = appointmentRepository.findAll();
            List <Integer> employeeServicesId = new ArrayList<>();
            for (int i = 0; i < allAppointment.size(); i++){
                employeeServicesId.add(allAppointment.get(i).getEmployeeServices().getId());
            }
            int maxCount = 0;
            int maxId = 0;
            for (int i = 0; i < employeeServicesId.size(); i++){
                int count = 0;
                for (int j = 0; j < employeeServicesId.size(); j++){
                    if (Objects.equals(employeeServicesId.get(i), employeeServicesId.get(j))){
                        count ++;
                    }
                }
                if (count > maxCount){
                    maxCount = count;
                    maxId = employeeServicesId.get(i);
                }
            }
            services.add(employeeServicesRepository.findById(EmployeeServices.class, maxId).getService());
            String name = services.get(0).getName();
            services.addAll(serviceRepository.findByName(name));
            Set <Services> set = new HashSet<>(services);
            services.clear();
            services.addAll(set);
        }
        else {
            List <String> servicesName = new ArrayList<>();
            for (int i = 0; i < appointment.size(); i++) {
                if (!services.contains(appointment.get(i).getEmployeeServices().getService())){
                    services.add(appointment.get(i).getEmployeeServices().getService());
                }
                servicesName.add(appointment.get(i).getEmployeeServices().getService().getName());
            }
            for (int i = 0; i < servicesName.size(); i++) {
                List <Services> servicesByName = serviceRepository.findByName(servicesName.get(i));
                for (int j = 0; j < servicesByName.size(); j++) {
                    if (!services.contains(servicesByName.get(j))){
                        services.add(servicesByName.get(j));
                    }
                }
            }
        }

        List <ServicesDto> servicesDtos = new ArrayList<>();
        for (int i = 0; (i < services.size()) && (i<4); i++) {
            servicesDtos.add(mapper.map(services.get(i), ServicesDto.class));
        }
        return servicesDtos;
    }
}
