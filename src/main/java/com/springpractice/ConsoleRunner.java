package com.springpractice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Services;
import com.springpractice.services.AppointmentService;
import com.springpractice.services.ClientService;
import com.springpractice.services.EmployeeService;
import com.springpractice.services.EmployeeServicesService;
import com.springpractice.services.ServiceService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private EmployeeServicesService employeeServicesService;

    @Autowired
    private ServiceService serviceService;

    @Override
    public void run(String... strings) throws Exception {
        Employee employee = new Employee("Gruzdeva","Daria","Alexsandrovna", "email");
        employeeService.create(employee);

        Client client = new Client("Liza", "email@Liza");
        clientService.create(client);

        Client client2 = new Client("Kristina", "email@Kris");
        clientService.create(client2);

        Services service = new Services("nails", 10000);
        serviceService.create(service);

        Services service2 = new Services("brows", 3400);
        serviceService.create(service2);

        EmployeeServices employeeServices = new EmployeeServices(employee, service);
        employeeServicesService.create(employeeServices);

        EmployeeServices employeeServices2 = new EmployeeServices(employee, service2);
        employeeServicesService.create(employeeServices2);

        Appointment appointment = new Appointment(new Date(12333423), 12333423, client, employeeServices);
        appointmentService.create(appointment);
    }
}