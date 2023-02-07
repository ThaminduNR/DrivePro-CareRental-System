package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;

import java.sql.SQLException;

public interface HomeBO extends SuperBO {
    String loadCountOfCustomers() throws SQLException, ClassNotFoundException;

    String loadCountOfVehicle() throws SQLException, ClassNotFoundException;

    String loadCountOfBooking() throws SQLException, ClassNotFoundException;

    String loadCountOfReturn() throws SQLException, ClassNotFoundException;

    String loadCountOfReserveVehicle() throws SQLException, ClassNotFoundException;
}
