package com.example.cpbackend.service;

import com.example.cpbackend.entity.BookingOffice;
import org.springframework.data.domain.Page;

public interface IBookingOfficeService {
    void createBookingOffice(BookingOffice bookingOffice);

    Page<BookingOffice> getAllBookingOffice(int page, int pageSize);

    BookingOffice getBookingOfficeById(int id);

    void updateBookingOffice(BookingOffice bookingOffice);

    void deleteBookingOffice(int id);
}
