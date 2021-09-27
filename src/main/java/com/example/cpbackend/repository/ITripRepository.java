package com.example.cpbackend.repository;


import com.example.cpbackend.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITripRepository extends JpaRepository<Trip, Integer> {
    Trip findTripByTripId(int id);

    void deleteTripByTripId(int id);
}
