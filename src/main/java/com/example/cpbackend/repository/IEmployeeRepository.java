package com.example.cpbackend.repository;

import com.example.cpbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByAccount(String account);

    Employee findEmployeeByEmployeeId(int id);

    void deleteEmployeeByEmployeeId(int id);
}
