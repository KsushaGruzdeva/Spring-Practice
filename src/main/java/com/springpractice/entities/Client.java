package com.springpractice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table (name = "client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client extends BaseEntity {
    private String name;
    private String email;

    protected Client() {}

    public Client (String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Column (name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }
}
