package com.springpractice.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpractice.entities.Employee;
import com.springpractice.repositories.EmployeeRepository;

@Repository
public class EmployeeRepositoryDao implements EmployeeRepository {
    @Autowired
    private BaseEmployeeRepository baseRepository;

    @Override
    public Optional<Employee> findById(int id) {
        return baseRepository.findById(id);
    }

    @Override
    public Employee create (Employee employee) {
        return baseRepository.save(employee);
    }

    @Override
    public List <Employee> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return baseRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }

    @Override
    public List <Employee> findAll () {
        return baseRepository.findAll();
    }
}

@Repository
interface BaseEmployeeRepository extends JpaRepository <Employee, Integer> {
    @Query(value = "select e from Employee e where e.surname = :surname and e.name = :name and e.patronymic = :patronymic")
    List <Employee> findAllBySurnameAndNameAndPatronymic (@Param(value = "surname") String surname,
                                                         @Param(value = "name") String name,
                                                         @Param(value = "patronymic") String patronymic);
}