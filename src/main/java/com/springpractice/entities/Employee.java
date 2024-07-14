package com.springpractice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table (name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends BaseEntity {
    private String surname;
    private String name;
    private String patronymic;
    private String email;

    protected Employee() {}

    public Employee (String surname, String name, String patronymic, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
    }

    @Column (name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Column (name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic (String patronymic) {
        this.patronymic = patronymic;
    }

    @Column (name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }
}
