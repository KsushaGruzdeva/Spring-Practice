package com.springpractice.repositories;

import com.springpractice.entities.Employee;
import com.springpractice.entities.EmployeeServices;
import com.springpractice.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeServicesRepository extends JpaRepository {
    //Search all services, that made by one employee by his id
    @Query(value = "select es.service from EmployeeServices es join es.employee e where e.id = :id")
    List<Service> findAllServiceByEmployeeId (@Param(value = "id") Employee id);

    //Search all employees, which do one service by his id
    @Query(value = "select es.employee from EmployeeServices es join es.service s where s.id = :id")
    List<Employee> findAllEmployeeByServiceId (@Param(value = "id") Service id);
}
