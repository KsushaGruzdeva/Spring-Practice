package com.springpractice.dtos;

public class CreateServicesDto {
    private int price;
    private String name;

    protected CreateServicesDto() {}

    public CreateServicesDto (int price, String name) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }
}
