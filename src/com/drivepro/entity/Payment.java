package com.drivepro.entity;

public class Payment {
    private String paymentId;
    private String custId;
    private String paydate;
    private String payTime;
    private String vehicleNo;
    private double totalPay;
    private String method;

    public Payment(String paymentId, String custId, String paydate, String payTime, String vehicleNo, double totalPay, String method) {
        this.paymentId = paymentId;
        this.custId = custId;
        this.paydate = paydate;
        this.payTime = payTime;
        this.vehicleNo = vehicleNo;
        this.totalPay = totalPay;
        this.method = method;
    }

    public Payment() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
