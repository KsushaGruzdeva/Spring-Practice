package com.springpractice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table (name = "service")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Services extends BaseEntity {
    private String name;
    private int price;

    protected Services() {}

    public Services (String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Column (name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }
}
