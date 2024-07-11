package com.springpractice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public abstract class BaseEntity {
    private int id;
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
}
