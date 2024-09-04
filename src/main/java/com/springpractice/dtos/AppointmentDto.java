package com.springpractice.dtos;

import java.util.Date;

public class AppointmentDto {
    private int id;
    private Date date;
    private String clientName;
    private String employeeServicesServiceName;
    private String employeeServicesEmployeeName;
    private int employeeServicesServicePrice;
    protected AppointmentDto() {}

    public AppointmentDto (int id, Date date, String clientName, String employeeServicesServiceName, String employeeServicesEmployeeName, int employeeServicesServicePrice) {
        this.id = id;
        this.date = date;
        this.clientName = clientName;
        this.employeeServicesServiceName = employeeServicesServiceName;
        this.employeeServicesEmployeeName = employeeServicesEmployeeName;
        this.employeeServicesServicePrice = employeeServicesServicePrice;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName (String clientName) {
        this.clientName = clientName;
    }

    public String getEmployeeServicesServiceName() {
        return employeeServicesServiceName;
    }

    public void setEmployeeServicesServiceName (String employeeServicesServiceName) {
        this.employeeServicesServiceName = employeeServicesServiceName;
    }

    public String employeeServicesEmployeeName() {
        return employeeServicesEmployeeName;
    }

    public void employeeServicesEmployeeName (String employeeServicesEmployeeName) {
        this.employeeServicesEmployeeName = employeeServicesEmployeeName;
    }
    public int getEmployeeServicesServicePrice() {
        return employeeServicesServicePrice;
    }

    public void setEmployeeServicesServicePrice (int employeeServicesServicePrice) {
        this.employeeServicesServicePrice = employeeServicesServicePrice;
    }
}
