package com.springpractice.dtos;

public class EmployeeDto {
    private int id;
    private String email;
    private String name;
    private String patronymic;
    private String surname;

    protected EmployeeDto() {}

    public EmployeeDto (int id, String email, String name, String patronymic, String surname) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic (String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }
}
