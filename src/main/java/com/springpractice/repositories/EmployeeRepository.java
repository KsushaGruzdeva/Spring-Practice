package com.springpractice.repositories;

import com.springpractice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository{
    //Search all employees by surname and name and patronymic
    @Query(value = "select e from Employee e where e.surname = :surname and e.name = :name and e.patronymic = :patronymic")
    List<Employee> findAllBySurnameAndNameAndPatronymic (@Param(value = "surname") Employee surname,
                                                         @Param(value = "name") Employee name,
                                                         @Param(value = "patronymic") Employee patronymic);
}
