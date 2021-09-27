package com.example.cpbackend.controller;

import com.example.cpbackend.apiresponse.ApiResponse;
import com.example.cpbackend.entity.Employee;
import com.example.cpbackend.entity.Trip;
import com.example.cpbackend.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/trip")
public class TripController {
    @Autowired
    ITripService iTripService;
    @Autowired
    ApiResponse apiResponse;

    @PostMapping("/create")
    public ResponseEntity<?> createTrip(@RequestBody Trip trip){
        boolean created = iTripService.createTrip(trip);
        if (created){
            return apiResponse.successResponse(null, "Create successful", true);
        }
        return null;
    }

    @GetMapping("/read")
    public ResponseEntity<?> getAllTrip(@RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "10") int pageSize) {
        Page<Trip> pageTrip = iTripService.getAllTrip(pageIndex, pageSize);
        return apiResponse.successResponseArrayWithPaging(pageTrip.getContent(), "Success", pageIndex, pageSize, (int) pageTrip.getTotalElements(), true);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getEmployeeById(@RequestParam int id) {
        Trip trip = iTripService.getTripById(id);
        return apiResponse.successResponse(trip, "Success", true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Trip trip) {
        try {
            iTripService.updateTrip(trip);
            return apiResponse.successResponse(null, "Update Trip successful", true);
        } catch (EmptyResultDataAccessException e) {
            return apiResponse.errorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, false);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam int id) {
        try {
            iTripService.deleteTrip(id);
            return apiResponse.successResponse(null, "Delete Trip successful", true);
        } catch (EmptyResultDataAccessException e) {
            return apiResponse.errorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, false);
        }
    }
}
