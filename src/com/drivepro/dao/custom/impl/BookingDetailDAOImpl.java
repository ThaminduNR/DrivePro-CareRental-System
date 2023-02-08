package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.BookingDetailDAO;
import com.drivepro.dto.BookingDetailsDTO;
import com.drivepro.dao.CrudUtil;
import com.drivepro.entity.BookingDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDetailDAOImpl implements BookingDetailDAO {

    @Override
    public boolean add(BookingDetails bookingDetails) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO bookingdetail VALUES(?,?,?,?)";

        return CrudUtil.execute(sql,

                bookingDetails.getBookingId(),
                bookingDetails.getVehicleNo(),
                bookingDetails.getDayOfCharge(),
                bookingDetails.getDayCount()

        );
    }

    @Override
    public ArrayList<BookingDetails> getAll(){
        return null;
    }

    @Override
    public boolean update(BookingDetails bookingDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
