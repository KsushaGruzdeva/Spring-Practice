package com.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springpractice.entities.Employee;
import com.springpractice.services.EmployeeService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... strings) throws Exception {
        Employee employee = new Employee("Gruzdeva","Ksenia","Alexsandrovna", "email");
        employeeService.create(employee);
    }
}