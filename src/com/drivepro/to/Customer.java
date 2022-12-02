package com.drivepro.to;

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String contact;
    private int age;
    private String dob;

    public Customer(String customerId, String name, String address, String contact, int age, String dob) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.age = age;
        this.dob = dob;
    }

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
