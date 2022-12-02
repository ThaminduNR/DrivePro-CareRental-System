package com.drivepro.controller;

import com.drivepro.db.DBConnection;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeFormController {
    public AnchorPane MainContext;
    public Label lblCustomer;
    public Label lblVehicles;
    public Label lblBook;
    public Label lblReturn;
    public Label lblreserve;

    public void initialize(){
        loadCountOfCustomers();
        loadCountOfVehicle();
        loadCountOfBooking();
        loadCountOfReturn();
        loadCountOfReserveVehicle();
    }
    private void loadCountOfCustomers() {
        String count = "";
        try {
            String sql = "SELECT COUNT(customerId) FROM customer";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblCustomer.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void loadCountOfVehicle() {
        String count = "";
        try {
            String sql = "SELECT COUNT(vehicleNo) FROM vehicle";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblVehicles.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void loadCountOfBooking() {
        String count = "";
        try {
            String sql = "SELECT COUNT(bookingId) FROM booking";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblBook.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void loadCountOfReturn() {
        String count = "";
        try {
            String sql = "SELECT COUNT(vehicleNo) FROM returnvehicle";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblReturn.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void loadCountOfReserveVehicle() {
        String count = "";
        try {
            String sql = "SELECT COUNT(vehicleNo) FROM vehicleDetail";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblreserve.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
