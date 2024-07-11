package com.springpractice.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "employee_services")
public class EmployeeServices extends BaseEntity {
    private Employee employee;
    private Service service;

    protected EmployeeServices() {}

    public EmployeeServices (Employee employee, Service service) {
        this.employee = employee;
        this.service = service;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "employee_id", referencedColumnName = "id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee (Employee employee) {
        this.employee = employee;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "service_id", referencedColumnName = "id")
    public Service getService() {
        return service;
    }

    public void setService (Service service) {
        this.service = service;
    }
}
