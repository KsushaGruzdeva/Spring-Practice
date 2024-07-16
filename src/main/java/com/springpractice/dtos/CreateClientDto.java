package com.springpractice.dtos;

public class CreateClientDto {
    private String email;
    private String name;

    protected CreateClientDto() {}

    public CreateClientDto (String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }
}
