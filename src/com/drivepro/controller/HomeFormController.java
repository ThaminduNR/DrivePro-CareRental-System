package com.drivepro.controller;

import com.drivepro.bo.BOFactory;
import com.drivepro.bo.BOTypes;
import com.drivepro.bo.custom.HomeBO;
import com.drivepro.bo.custom.impl.HomeBOImpl;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class HomeFormController {
    public AnchorPane MainContext;
    public Label lblCustomer;
    public Label lblVehicles;
    public Label lblBook;
    public Label lblReturn;
    public Label lblReseve;



     HomeBO homeBO = (HomeBO) BOFactory.getBoFactory().getBO(BOTypes.HOME);

    public void initialize(){
        loadCountOfCustomers();
        loadCountOfVehicle();
        loadCountOfBooking();
        loadCountOfReturn();
        loadCountOfReserveVehicle();
    }

    private void loadCountOfCustomers() {
        try {
            String count = homeBO.loadCountOfCustomers();
            lblCustomer.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfVehicle() {
        try {
            String count = homeBO.loadCountOfVehicle();
            lblVehicles.setText(count);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfBooking() {
        try {
            String count = homeBO.loadCountOfBooking();
            lblBook.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfReturn() {
        try {
            String count = homeBO.loadCountOfReturn();
            lblReturn.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfReserveVehicle() {
        try {
            String count = homeBO.loadCountOfReserveVehicle();
            lblReseve.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
