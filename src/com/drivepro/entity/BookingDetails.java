package com.drivepro.entity;

public class BookingDetails {
    private String bookingId;
    private String vehicleNo;
    private int dayCount;
    private double dayOfCharge;

    public BookingDetails(String bookingId, String vehicleNo, int dayCount, double dayOfCharge) {
        this.bookingId = bookingId;
        this.vehicleNo = vehicleNo;
        this.dayCount = dayCount;
        this.dayOfCharge = dayOfCharge;
    }

    public BookingDetails() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public double getDayOfCharge() {
        return dayOfCharge;
    }

    public void setDayOfCharge(double dayOfCharge) {
        this.dayOfCharge = dayOfCharge;
    }
}
