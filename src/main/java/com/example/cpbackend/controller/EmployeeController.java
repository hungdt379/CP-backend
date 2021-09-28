package com.example.cpbackend.controller;

import com.example.cpbackend.apiresponse.ApiResponse;
import com.example.cpbackend.entity.Employee;
import com.example.cpbackend.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    ApiResponse apiResponse;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        boolean created = iEmployeeService.createEmployee(employee);
        if (created) {
            return apiResponse.successResponse(null, "Create successful", true);
        } else {
            return apiResponse.errorResponse("Existed employee with account: " + employee.getAccount(), HttpStatus.CONFLICT, false);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<?> getAllEmployee(@RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "10") int pageSize) {
        Page<Employee> pageEmployee = iEmployeeService.getAllEmployee(pageIndex, pageSize);
        return apiResponse.successResponseArrayWithPaging(pageEmployee.getContent(), "Success", pageIndex, pageSize, (int) pageEmployee.getTotalElements(), true);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getEmployeeById(@RequestParam int id) {
        Employee employee = iEmployeeService.getEmployeeById(id);
        return apiResponse.successResponse(employee, "Success", true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            iEmployeeService.updateEmployee(employee);
            return apiResponse.successResponse(null, "Update employee successful", true);
        } catch (EmptyResultDataAccessException e) {
            return apiResponse.errorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, false);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam int id) {
        try {
            iEmployeeService.deleteEmployee(id);
            return apiResponse.successResponse(null, "Delete Employee successful", true);
        } catch (EmptyResultDataAccessException e) {
            return apiResponse.errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST, false);
        }
    }

}
