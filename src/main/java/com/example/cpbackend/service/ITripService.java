package com.example.cpbackend.service;

import com.example.cpbackend.entity.Trip;
import org.springframework.data.domain.Page;

public interface ITripService {
    boolean createTrip(Trip trip);

    Page<Trip> getAllTrip(int pageIndex, int pageSize);

    Trip getTripById(int id);

    void updateTrip(Trip trip);

    void deleteTrip(int id);
}
