package com.example.cpbackend.service.imp;

import com.example.cpbackend.entity.BookingOffice;
import com.example.cpbackend.repository.IBookingOfficeRepository;
import com.example.cpbackend.service.IBookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookingOfficeService implements IBookingOfficeService {
    @Autowired
    IBookingOfficeRepository iBookingOfficeRepository;

    @Override
    public void createBookingOffice(BookingOffice bookingOffice) {
        iBookingOfficeRepository.save(bookingOffice);
    }

    @Override
    public Page<BookingOffice> getAllBookingOffice(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return iBookingOfficeRepository.findAll(pageable);
    }

    @Override
    public BookingOffice getBookingOfficeById(int id) {
        return null;
    }

    @Override
    public void updateBookingOffice(BookingOffice bookingOffice) {

    }

    @Override
    public void deleteBookingOffice(int id) {

    }
}
