package com.springpractice.repositories;

import com.springpractice.entities.Appointment;
import com.springpractice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    //Search all appointments for one client by his id
    @Query(value = "select a from Appointment a join a.client c where c.id = :id")
    List<Appointment> findAllByClientId (@Param(value = "id") Client id);

    //Search all appointments by time and date
    @Query(value = "select a from Appointment a where a.time = :time and a.date = :date")
    List<Appointment> findAllByTimeAndDate (@Param(value = "time") Appointment time,
                                            @Param(value = "date") Appointment date);
}
