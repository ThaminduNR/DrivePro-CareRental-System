package com.drivepro.dto;

import java.io.Serializable;

public class BookingDTO implements Serializable {
    private String bookingId;
    private String date;
    private double totalCost;
    private String custId;

    public BookingDTO() {
    }

    public BookingDTO(String bookingId, String date, double totalCost, String custId) {
        this.bookingId = bookingId;
        this.date = date;
        this.totalCost = totalCost;
        this.custId = custId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
