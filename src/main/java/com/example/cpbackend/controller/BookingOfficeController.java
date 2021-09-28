package com.example.cpbackend.controller;

import com.example.cpbackend.apiresponse.ApiResponse;
import com.example.cpbackend.entity.BookingOffice;
import com.example.cpbackend.service.IBookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking-office")
public class BookingOfficeController {
    @Autowired
    IBookingOfficeService iBookingOfficeService;

    @Autowired
    ApiResponse apiResponse;

    @PostMapping("/create")
    public ResponseEntity<?> createBookingOffice(@RequestBody BookingOffice bookingOffice) {
        iBookingOfficeService.createBookingOffice(bookingOffice);
        return apiResponse.successResponse(null, "Insert success", true);
    }

    @GetMapping("/read")
    public ResponseEntity<?> getAllBookingOffice(@RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "10") int pageSize) {
        Page<BookingOffice> page = iBookingOfficeService.getAllBookingOffice(pageIndex, pageSize);
        return apiResponse.successResponseArrayWithPaging(page.getContent(), "Success", pageIndex, pageSize, (int) page.getTotalElements(), true);
    }

}
