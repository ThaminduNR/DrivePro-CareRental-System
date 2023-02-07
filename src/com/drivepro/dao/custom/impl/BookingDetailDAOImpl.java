package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.BookingDetailDAO;
import com.drivepro.dto.BookingDetailsDTO;
import com.drivepro.dao.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDetailDAOImpl implements BookingDetailDAO {

    @Override
    public boolean add(BookingDetailsDTO bookingDetailsDTO) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO bookingdetail VALUES(?,?,?,?)";

        return CrudUtil.execute(sql,

                bookingDetailsDTO.getBookingId(),
                bookingDetailsDTO.getVehicleNo(),
                bookingDetailsDTO.getDayOfCharge(),
                bookingDetailsDTO.getDayCount()

        );
    }

    @Override
    public ArrayList<BookingDetailsDTO> getAll(){
        return null;
    }

    @Override
    public boolean update(BookingDetailsDTO bookingDetailsDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
