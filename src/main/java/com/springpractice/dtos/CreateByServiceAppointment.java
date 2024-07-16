package com.springpractice.dtos;

import java.util.Date;

public class CreateByServiceAppointment {
    private Date date;
    private Date time;
    private int clientId;
    private int servicesId;

    protected CreateByServiceAppointment() {}

    public CreateByServiceAppointment (int clientId, Date date, int servicesId, Date time) {
        this.date = date;
        this.time = time;
        this.clientId = clientId;
        this.servicesId = servicesId;
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

    public int getServicesId() {
        return servicesId;
    }

    public void setServicesId (int servicesId) {
        this.servicesId = servicesId;
    }
}
