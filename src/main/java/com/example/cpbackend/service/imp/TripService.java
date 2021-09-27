package com.example.cpbackend.service.imp;

import com.example.cpbackend.entity.Trip;
import com.example.cpbackend.repository.ITripRepository;
import com.example.cpbackend.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TripService implements ITripService {
    @Autowired
    ITripRepository iTripRepository;

    @Override
    public boolean createTrip(Trip trip) {
        iTripRepository.save(trip);
        return true;
    }

    @Override
    public Page<Trip> getAllTrip(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        return iTripRepository.findAll(pageable);
    }

    @Override
    public Trip getTripById(int id) {
        return iTripRepository.findTripByTripId(id);
    }

    @Override
    public void updateTrip(Trip trip) {
        Trip updateTrip = iTripRepository.findTripByTripId(trip.getTripId());
        updateTrip.setBookedTicketNumber(trip.getBookedTicketNumber());
        updateTrip.setCarType(trip.getCarType());
        updateTrip.setDepartureDate(trip.getDepartureDate());
        updateTrip.setDestination(trip.getDestination());
        updateTrip.setMaximumOnlineTicketNumber(trip.getMaximumOnlineTicketNumber());
        updateTrip.setDriver(trip.getDriver());
        iTripRepository.save(updateTrip);
    }

    @Override
    public void deleteTrip(int id) {
        iTripRepository.deleteTripByTripId(id);
    }
}
