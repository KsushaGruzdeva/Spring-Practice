package com.springpractice.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "appointment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Appointment extends BaseEntity {
    private Date date;
    private Client client;
    private EmployeeServices employeeServices;

    protected Appointment() {}

    public Appointment (Date date, Client client, EmployeeServices employeeServices) {
        this.date = date;
        this.client = client;
        this.employeeServices = employeeServices;
    }

    @Column (name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "client_id", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    public void setClient (Client client) {
        this.client = client;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "employeeServices_id", referencedColumnName = "id")
    public EmployeeServices getEmployeeServices() {
        return employeeServices;
    }

    public void setEmployeeServices (EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }
}
