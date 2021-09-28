package com.example.cpbackend.repository;

import com.example.cpbackend.entity.BookingOffice;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBookingOfficeRepository extends JpaRepository<BookingOffice, Integer> {
}
