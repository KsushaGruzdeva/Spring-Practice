package com.springpractice.exceptions;

public class ServiceNotFoundException extends RuntimeException{
    public ServiceNotFoundException (Integer id){
        super ("Could not find service " + id);
    }
}
