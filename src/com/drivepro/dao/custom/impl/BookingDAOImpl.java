package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.BookingDAO;
import com.drivepro.dto.BookingDTO;
import com.drivepro.dao.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public boolean add(BookingDTO bookingDTO) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO booking VALUES (?,?,?,?)";

        return CrudUtil.execute(sql,

                bookingDTO.getBookingId(),
                bookingDTO.getDate(),
                bookingDTO.getTotalCost(),
                bookingDTO.getCustId()

        );
    }

    @Override
    public ArrayList<BookingDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(BookingDTO bookingDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT bookingId FROM booking ORDER BY bookingId DESC LIMIT 1");
        return rst.next() ? rst.getString("bookingId"):null;
    }

    @Override
    public boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicle SET  status = 'Unavailable' WHERE vehicleNo = ?";
        return CrudUtil.execute(sql, id);

    }

    @Override
    public ObservableList<String> loadCustomerId() throws SQLException, ClassNotFoundException {
        ResultSet idSet = CrudUtil.execute("SELECT  customerId FROM customer");
        ObservableList<String> cusIdlist = FXCollections.observableArrayList();
        while (idSet.next()){
            cusIdlist.add(idSet.getString(1));
        }
        return cusIdlist;
    }

    @Override
    public ObservableList<String> loadVehicleNumber() throws SQLException, ClassNotFoundException {
        ResultSet VNumber = CrudUtil.execute("SELECT vehicleNo FROM  Vehicle");
        ObservableList<String> vIdList = FXCollections.observableArrayList();
        while (VNumber.next()) {
            vIdList.add(VNumber.getString(1));
        }
        return vIdList;
    }

    @Override
    public ResultSet ChangeStateVehicleNo(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Vehicle WHERE vehicleNo =?", id);
    }

    @Override
    public ResultSet changeStateCustID(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM customer WHERE customerId=?", id);
    }

    @Override
    public String loadCountOfBooking() throws SQLException, ClassNotFoundException {
        String count = "";
        String sql = "SELECT COUNT(bookingId) FROM booking";
        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()) {
            count = rst.getString(1);
        }
        return count;
    }

}
