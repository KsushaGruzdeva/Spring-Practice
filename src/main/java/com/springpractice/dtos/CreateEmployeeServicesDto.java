package com.springpractice.dtos;

public class CreateEmployeeServicesDto {
    private int employeeId;
    private int serviceId;

    protected CreateEmployeeServicesDto() {}

    public CreateEmployeeServicesDto (int employeeId, int service) {
        this.employeeId = employeeId;
        this.serviceId = service;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId (int employee) {
        this.employeeId = employee;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId (int service) {
        this.serviceId = service;
    }
}
