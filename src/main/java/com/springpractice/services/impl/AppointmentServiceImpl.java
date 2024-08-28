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
import com.springpractice.dtos.CreateAppointmentDto;
import com.springpractice.dtos.CreateByServiceAppointment;
import com.springpractice.dtos.ServicesDto;
import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.exceptions.AppointmentNotCreateException;
import com.springpractice.exceptions.ClientNotFoundException;
import com.springpractice.exceptions.ServiceNotFoundException;
import com.springpractice.repositories.impl.AppointmentRepositoryImpl;
import com.springpractice.repositories.impl.ClientRepositoryImpl;
import com.springpractice.repositories.impl.EmployeeServicesRepositoryImpl;
import com.springpractice.repositories.impl.ServiceRepositoryImpl;
import com.springpractice.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private AppointmentRepositoryImpl appointmentRepository;

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @Autowired
    private ServiceRepositoryImpl serviceRepository;

    @Autowired
    private EmployeeServicesRepositoryImpl employeeServicesRepository;

    @Override
    public AppointmentDto findById(int id) {
        Appointment appointment = appointmentRepository.findById(Appointment.class, id);
        return mapper.map(appointment, AppointmentDto.class);
    }

    @Override
    public void create(CreateAppointmentDto createAppointmentDto) {
        Client client = clientRepository.findById(Client.class, createAppointmentDto.getClientId());
        System.out.println(createAppointmentDto.getClientId());
        EmployeeServices employeeServices = employeeServicesRepository.findById(EmployeeServices.class, createAppointmentDto.getEmployeeServices());

        Appointment appointment = new Appointment(createAppointmentDto.getDate(), createAppointmentDto.getTime(), client, employeeServices);
        appointmentRepository.create(appointment);
    }

    @Override
    public List<AppointmentDto> findAllByClient (Client client) {
        List <Appointment> appointment = appointmentRepository.findAllByClient(client);
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
        // НАДО выводить ошибку, если пользователя не существует.
        try {
            Client client = clientRepository.findById(Client.class, id);
            if (client == null)
                throw new ClientNotFoundException(id);
            List <Appointment> appointments = appointmentRepository.findAllByClient(client);
            return appointments.isEmpty() || (appointments.size() + 1) % 5 == 0;
        } catch (ClientNotFoundException e) {
            System.err.println("Error finding this client: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void createByService (CreateByServiceAppointment createByServiceAppointmentDto) {
        Client client = clientRepository.findById(Client.class, createByServiceAppointmentDto.getClientId());
        if (client == null)
            throw new ClientNotFoundException(createByServiceAppointmentDto.getClientId());
        System.out.println(createByServiceAppointmentDto.getClientId());
        Services services = serviceRepository.findById(Services.class, createByServiceAppointmentDto.getServicesId());
        if (services == null)
            throw new ServiceNotFoundException(createByServiceAppointmentDto.getServicesId());
        System.out.println(services.getId());
        List <EmployeeServices> employeeServices = employeeServicesRepository.findAllByServiceId(services.getId());

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

        // Выводить ошибку, если недоступна запись на это время, так как нет свободных мастеров.

        if (employeeServices.isEmpty())
            throw new AppointmentNotCreateException();

        // Проверить есть ли скидка и вывести новую цену, как я не знаю,
        // ведь мы ссылаемся на конкретный сервис, в котором хранится цена

        // if (isDiscount(client.getId())) {
        //     int price = employeeServices.get(0).getService().getPrice();
        //     price -= 500;
        //     serviceRepository.update(employeeServices.get(0).getService());
        // }

        Appointment appointment = new Appointment(createByServiceAppointmentDto.getDate(), createByServiceAppointmentDto.getTime(), client, employeeServices.get(0));
        appointmentRepository.create(appointment);
    }

    @Override
    public List<ServicesDto> recomandation (int clientId) {
        // НАДО выводить ошибку, если пользователя не существует.
        Client client = clientRepository.findById(Client.class, clientId);
        if (client == null)
            throw new ClientNotFoundException(clientId);
        List <Appointment> appointment = appointmentRepository.findAllByClient(client);
        List <Services> services = new ArrayList<>();
        if (appointment.isEmpty())
        {
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
        }

        List <ServicesDto> servicesDtos = new ArrayList<>();
        for (int i = 0; (i < services.size()) && (i<4); i++) {
            servicesDtos.add(mapper.map(services.get(i), ServicesDto.class));
        }
        return servicesDtos;
    }
}
