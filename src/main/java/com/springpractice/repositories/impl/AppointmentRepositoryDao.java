package com.springpractice.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import com.springpractice.repositories.AppointmentRepository;

@Repository
public class AppointmentRepositoryDao implements AppointmentRepository{
    @Autowired
    private BaseAppointmentRepository baseRepository;

    @Override
    public Optional<Appointment> findById (int id) {
        return baseRepository.findById(id);
    }

    @Override
    public void create (Appointment appointment) {
        baseRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAllByClientId (Client id) {
        return baseRepository.findAllByClientId (id);
    }

    @Override
    public List<Appointment> findAllByTimeAndDate (Appointment time, Appointment date) {
        return baseRepository.findAllByTimeAndDate (time, date);
    }
}

@Repository
interface BaseAppointmentRepository extends JpaRepository<Appointment, Integer> {
    //Search all appointments for one client by his id
    @Query(value = "select a from Appointment a join a.client c where c.id = :id")
    List<Appointment> findAllByClientId (@Param(value = "id") Client id);

    //Search all appointments by time and date
    @Query(value = "select a from Appointment a where a.time = :time and a.date = :date")
    List<Appointment> findAllByTimeAndDate (@Param(value = "time") Appointment time,
                                            @Param(value = "date") Appointment date);
}
