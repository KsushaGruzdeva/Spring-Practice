package com.springpractice.dtos;

import java.util.Date;

public class CreateAppointmentDto {
    private Date date;
    private Date time;
    private int clientId;
    private int employeeServicesId;

    protected CreateAppointmentDto() {}

    public CreateAppointmentDto (int clientId, Date date, int employeeServicesId, Date time) {
        this.date = date;
        this.time = time;
        this.clientId = clientId;
        this.employeeServicesId = employeeServicesId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime (Date time) {
        this.time = time;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId (int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeServices() {
        return employeeServicesId;
    }

    public void setEmployeeServicesId (int employeeServicesId) {
        this.employeeServicesId = employeeServicesId;
    }
}
