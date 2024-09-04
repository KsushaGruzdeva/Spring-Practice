package com.springpractice.dtos;

public class DiscountDto {
    private String name;
    private int discountPercentage;

    protected DiscountDto() {}

    public DiscountDto (String name, int discountPercentage) {
        this.name = name;
        this.discountPercentage = discountPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setPrice (int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
