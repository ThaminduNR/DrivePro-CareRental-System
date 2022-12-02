package com.drivepro.to;

public class Cashier {
    private String cashierId;
    private String name;
    private String address;
    private String contact;
    private int age;
    private String  password;

    public Cashier(String cashierId, String name, String address, String contact, int age, String password) {
        this.cashierId = cashierId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.age = age;
        this.password = password;
    }

    public Cashier() {

    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
