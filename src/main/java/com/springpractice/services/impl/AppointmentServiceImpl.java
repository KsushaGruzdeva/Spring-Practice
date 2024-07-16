package com.springpractice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.dtos.AppointmentDto;
import com.springpractice.dtos.CreateAppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.repositories.AppointmentRepository;
import com.springpractice.repositories.ClientRepository;
import com.springpractice.repositories.EmployeeServicesRepository;
import com.springpractice.repositories.ServiceRepository;
import com.springpractice.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private EmployeeServicesRepository employeeServicesRepository;

    @Override
    public Optional<AppointmentDto> findById(int id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        return Optional.of(mapper.map(appointmentOptional.get(), AppointmentDto.class));
    }

    @Override
    public AppointmentDto create(CreateAppointmentDto createAppointmentDto) {
        Optional <Client> client = clientRepository.findById(createAppointmentDto.getClientId());
        System.out.println(createAppointmentDto.getClientId());
        Optional <EmployeeServices> employeeServices = employeeServicesRepository.findById(createAppointmentDto.getEmployeeServices());

        Appointment appointment = new Appointment(createAppointmentDto.getDate(), createAppointmentDto.getTime(), client.get(), employeeServices.get());
        return mapper.map(appointmentRepository.create(appointment), AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> findAllByClient (Optional <Client> client) {
        List <Appointment> appointment = appointmentRepository.findAllByClient (client);
        List <AppointmentDto> appointmentDtos = new ArrayList<>();
        for (int i = 0; i < appointment.size(); i++) {
            appointmentDtos.add(mapper.map(appointment.get(i), AppointmentDto.class));
        }
        return appointmentDtos;
    }

    @Override
    public List<AppointmentDto> findAll () {
        List <Appointment> appointment = appointmentRepository.findAll();
        List <AppointmentDto> appointmentDtos = new ArrayList<>();
        for (int i = 0; i < appointment.size(); i++) {
            appointmentDtos.add(mapper.map(appointment.get(i), AppointmentDto.class));
        }
        return appointmentDtos;
    }

    @Override
    public List<AppointmentDto> findAllByEmployeeService (EmployeeServices employeeServices) {
        List <Appointment> appointment = appointmentRepository.findAllByEmployeeService(employeeServices);
        List <AppointmentDto> appointmentDtos = new ArrayList<>();
        for (int i = 0; i < appointment.size(); i++) {
            appointmentDtos.add(mapper.map(appointment.get(i), AppointmentDto.class));
        }
        return appointmentDtos;
    }

    @Override
    public Boolean isDiscount (int id){
        Optional <Client> client = clientRepository.findById(id);
        List <Appointment> appointments = appointmentRepository.findAllByClient(client);
        return appointments.isEmpty() || appointments.size()%5 == 0;
    }

    @Override
    public AppointmentDto createByService (CreateByServiceAppointment createByServiceAppointmentDto) {
        Optional <Client> client = clientRepository.findById(createByServiceAppointmentDto.getClientId());
        System.out.println(createByServiceAppointmentDto.getClientId());
        Optional <Services> services = serviceRepository.findById(createByServiceAppointmentDto.getServicesId());
        List <EmployeeServices> employeeServices = employeeServicesRepository.findAllByServiceId(services.get().getId());

        List <Appointment> allAppointment = new ArrayList<>();

        for (int i = 0; i < employeeServices.size(); i++) {
            List <Appointment> appointmentByEmployeeService = appointmentRepository.findAllByEmployeeService(employeeServices.get(i));
            for (int j = 0; j < appointmentByEmployeeService.size(); j++) {
                if (appointmentByEmployeeService.get(j).getDate().getTime() == createByServiceAppointmentDto.getDate().getTime() && appointmentByEmployeeService.get(j).getTime().getTime() == (createByServiceAppointmentDto.getTime().getTime()))
                    allAppointment.add(appointmentByEmployeeService.get(j));
            }
        }

        List <EmployeeServices> employeeServicesBlocked = new ArrayList<>();
        for (int i = 0; i < allAppointment.size(); i++) {
            employeeServicesBlocked.add(allAppointment.get(i).getEmployeeServices());
        }

        for (int i = 0; i < employeeServicesBlocked.size(); i++) {
            employeeServices.remove(employeeServicesBlocked.get(i));
        }

        Appointment appointment = new Appointment(createByServiceAppointmentDto.getDate(), createByServiceAppointmentDto.getTime(), client.get(), employeeServices.get(0));
        return mapper.map(appointmentRepository.create(appointment), AppointmentDto.class);
    }

    @Override
    public List<ServicesDto> recomandation (int clientId) {
        Optional <Client> client = clientRepository.findById(clientId);
        List <Appointment> appointment = appointmentRepository.findAllByClient(client);
        List <Services> services = new ArrayList<>();
        List <String> servicesName = new ArrayList<>();
        for (int i = 0; i < appointment.size(); i++) {
            if (!services.contains(appointment.get(i).getEmployeeServices().getService()))
                services.add(appointment.get(i).getEmployeeServices().getService());
            servicesName.add(appointment.get(i).getEmployeeServices().getService().getName());
        }
        for (int i = 0; i < servicesName.size(); i++) {
            List <Services> servicesByName = serviceRepository.findByName(servicesName.get(i));
            for (int j = 0; j < servicesByName.size(); j++) {
                if (!services.contains(servicesByName.get(j)))
                    services.add(servicesByName.get(j));
            }
        }
        List <ServicesDto> servicesDtos = new ArrayList<>();
        for (int i = 0; i < services.size(); i++) {
            servicesDtos.add(mapper.map(services.get(i), ServicesDto.class));
        }
        return servicesDtos;
    }
}
