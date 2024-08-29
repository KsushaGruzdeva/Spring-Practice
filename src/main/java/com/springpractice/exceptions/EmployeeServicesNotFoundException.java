package com.springpractice.exceptions;

public class EmployeeServicesNotFoundException extends RuntimeException{
    public EmployeeServicesNotFoundException (Integer id){
        super ("Could not find employeeServices " + id);
    }
}