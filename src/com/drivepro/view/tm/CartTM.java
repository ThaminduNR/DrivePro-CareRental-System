package com.drivepro.view.tm;


import javafx.scene.control.Button;

public class CartTM {
    private String id;
    private String name;
    private String Sdate;
    private String Edate;
    private int dayCount;
    private Double dayOfCharge;
    private Double total;
    private Button btn;

    public CartTM() {
    }

    public CartTM(String id, String name, String sdate, String edate, int dayCount, Double dayOfCharge, Double total, Button btn) {
        this.id = id;
        this.name = name;
        Sdate = sdate;
        Edate = edate;
        this.dayCount = dayCount;
        this.dayOfCharge = dayOfCharge;
        this.total = total;
        this.btn = btn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        Sdate = sdate;
    }

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String edate) {
        Edate = edate;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public Double getDayOfCharge() {
        return dayOfCharge;
    }

    public void setDayOfCharge(Double dayOfCharge) {
        this.dayOfCharge = dayOfCharge;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
