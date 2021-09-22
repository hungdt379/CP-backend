package com.example.cpbackend.service.imp;

import com.example.cpbackend.entity.Employee;
import com.example.cpbackend.repository.IEmployeeRepository;
import com.example.cpbackend.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean createEmployee(Employee employee) {
        Employee e = iEmployeeRepository.findEmployeeByAccount(employee.getAccount());
        if (e != null) {
            return false;
        } else {
            String password = employee.getPassword();
            employee.setPassword(passwordEncoder.encode(password));
            iEmployeeRepository.save(employee);
            return true;
        }
    }

    @Override
    public Page<Employee> getAllEmployee(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return iEmployeeRepository.findEmployeeByEmployeeId(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee updateEmployee = iEmployeeRepository.getById(employee.getEmployeeId());
        updateEmployee.setAccount(employee.getAccount());
        updateEmployee.setEmployeeName(employee.getEmployeeName());
        updateEmployee.setEmployeeEmail(employee.getEmployeeEmail());
        updateEmployee.setEmployeeAddress(employee.getEmployeeAddress());
        updateEmployee.setEmployeePhone(employee.getEmployeePhone());
        updateEmployee.setDepartment(employee.getDepartment());
        updateEmployee.setEmployeeBirthday(employee.getEmployeeBirthday());
        updateEmployee.setSex(employee.getSex());
        updateEmployee.setPassword(passwordEncoder.encode(employee.getPassword()));

        iEmployeeRepository.save(updateEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        iEmployeeRepository.deleteById(id);
    }

}
