package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.BookingDTO;
import javafx.collections.ObservableList;
import rex.utils.S;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookingDAO extends CrudDAO<BookingDTO, String> {

    String getLastOrderId() throws SQLException, ClassNotFoundException;

    boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException;

    ObservableList<String> loadCustomerId() throws SQLException, ClassNotFoundException;

    ObservableList<String> loadVehicleNumber() throws SQLException, ClassNotFoundException;

    ResultSet ChangeStateVehicleNo(String id) throws SQLException, ClassNotFoundException;

    ResultSet changeStateCustID(String id) throws SQLException, ClassNotFoundException;

    String loadCountOfBooking() throws SQLException, ClassNotFoundException;
}
