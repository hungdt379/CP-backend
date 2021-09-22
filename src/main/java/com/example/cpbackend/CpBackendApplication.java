package com.example.cpbackend;

import com.example.cpbackend.entity.Employee;
import com.example.cpbackend.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;


@SpringBootApplication
public class CpBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CpBackendApplication.class, args);
    }

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeAddress("Ha Noi");
        employee.setEmployeeEmail("hungdt379@gmail.com");
        employee.setEmployeeName("Dang The Hung");
        employee.setEmployeeBirthday(new Date());
        employee.setSex("M");
        employee.setDepartment("EC");
        employee.setEmployeePhone("0969550274");
        employee.setAccount("hungdt");
        employee.setPassword(passwordEncoder.encode("123"));
        iEmployeeRepository.save(employee);
    }
}
