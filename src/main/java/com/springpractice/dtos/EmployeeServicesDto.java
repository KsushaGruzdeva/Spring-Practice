package com.springpractice.dtos;

public class EmployeeServicesDto {
    private int id;
    private String employeeName;
    private String serviceName;

    protected EmployeeServicesDto() {}

    public EmployeeServicesDto (int id, String employeeName, String serviceName) {
        this.id = id;
        this.employeeName = employeeName;
        this.serviceName = serviceName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName (String employeeName) {
        this.employeeName = employeeName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName (String serviceName) {
        this.serviceName = serviceName;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }
}
