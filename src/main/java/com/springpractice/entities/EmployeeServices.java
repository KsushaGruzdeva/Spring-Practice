package com.springpractice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "employee_services")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EmployeeServices extends BaseEntity {
    private Employee employee;
    private Services service;

    protected EmployeeServices() {}

    public EmployeeServices (Employee employee, Services service) {
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
    public Services getService() {
        return service;
    }

    public void setService (Services service) {
        this.service = service;
    }
}
