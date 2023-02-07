package com.drivepro.entity;

public class VehicleDetails {
     private String vehicleNo;
     private String vehicleName;
     private String startDate;
     private String endDate;
     private int dayCount;
     private double dayOfCharge;
     private String CustId;

    public VehicleDetails(String vehicleNo, String vehicleName, String startDate, String endDate, int dayCount, double dayOfCharge, String custId) {
        this.vehicleNo = vehicleNo;
        this.vehicleName = vehicleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayCount = dayCount;
        this.dayOfCharge = dayOfCharge;
        CustId = custId;
    }

    public VehicleDetails() {
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }
}
