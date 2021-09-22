package com.example.cpbackend.service;

import com.example.cpbackend.entity.Employee;
import org.springframework.data.domain.Page;


public interface IEmployeeService {
    boolean createEmployee(Employee employee);

    Page<Employee> getAllEmployee(int page, int pageSize);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
