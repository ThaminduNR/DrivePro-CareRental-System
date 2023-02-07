package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;

import java.sql.SQLException;

public interface MainDBoardBO extends SuperBO {

    String loadCountOfVehicle() throws SQLException, ClassNotFoundException;

    String loadCountOfCustomers() throws SQLException, ClassNotFoundException;

    String loadCountOfBooking() throws SQLException, ClassNotFoundException;

    String loadCountOfReturn() throws SQLException, ClassNotFoundException;

    String loadCountOfReserveVehicle() throws SQLException, ClassNotFoundException;
}
