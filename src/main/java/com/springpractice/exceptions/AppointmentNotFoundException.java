package com.springpractice.exceptions;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException (Integer id){
        super ("Could not find appointment " + id);
    }
}
