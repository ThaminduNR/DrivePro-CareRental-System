package com.drivepro.dto;


import java.io.Serializable;

public class VehicleDTO implements Serializable {
    private String VehicleNo;
    private String name;
    private String brand;
    private double dayOfCharge;
    private String fuelType;
    private String vehicleType;
    private String image;
    private String status;

    public VehicleDTO() {
    }

    public VehicleDTO(String vehicleNo, String name, String brand, double dayOfCharge, String fuelType, String vehicleType, String image, String status) {
        VehicleNo = vehicleNo;
        this.name = name;
        this.brand = brand;
        this.dayOfCharge = dayOfCharge;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.image = image;
        this.status = status;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        VehicleNo = vehicleNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDayOfCharge() {
        return dayOfCharge;
    }

    public void setDayOfCharge(double dayOfCharge) {
        this.dayOfCharge = dayOfCharge;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

