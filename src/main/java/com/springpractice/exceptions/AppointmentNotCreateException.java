package com.springpractice.exceptions;

public class AppointmentNotCreateException extends RuntimeException {
    public AppointmentNotCreateException (){
        super ("Could not create appointment");
    }
}
