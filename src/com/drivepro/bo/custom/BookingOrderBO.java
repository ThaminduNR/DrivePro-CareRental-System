package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookingOrderBO extends SuperBO {
    
     boolean bookingOrder(String bookingId,String date,double totalCost,String custId, String num,String name,String sDate,String eDate,int dayCount,double dayCharge) throws SQLException;

     boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException;

     ObservableList<String> loadCustomerId() throws SQLException, ClassNotFoundException;

     ObservableList<String> loadVehicleNumber() throws SQLException, ClassNotFoundException;

     ResultSet ChangeStateVehicleNo(String num) throws SQLException, ClassNotFoundException;

     ResultSet changeStateCustID(String cust) throws SQLException, ClassNotFoundException;

    String getLastOrderId() throws SQLException, ClassNotFoundException;

}
