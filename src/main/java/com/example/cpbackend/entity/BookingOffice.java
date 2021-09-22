package com.example.cpbackend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bookingoffice")
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int officeId;
    @Column
    private Date endContractDeadline;
    @Column(nullable = false, length = 50)
    private String officeName;
    @Column(nullable = false, length = 11)
    private String officePhone;
    @Column(length = 50)
    private String officePlace;
    @Column(length = 20)
    private int officePrice;
    @Column
    private Date startContractDeadline;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public int getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(int officePrice) {
        this.officePrice = officePrice;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

}
