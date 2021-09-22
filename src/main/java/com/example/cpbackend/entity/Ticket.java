package com.example.cpbackend.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @Column
    private Time bookingTime;
    @Column(nullable = false, length = 11)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "license_plate")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


}
