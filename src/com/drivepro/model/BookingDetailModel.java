package com.drivepro.model;

import com.drivepro.to.BookingDetails;
import com.drivepro.util.CrudUtil;

import java.sql.SQLException;

public class BookingDetailModel {
    public static boolean addBookingDetail(BookingDetails bookingDetails) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO bookingdetail VALUES(?,?,?,?)";

        return CrudUtil.execute(sql,

                bookingDetails.getBookingId(),
                bookingDetails.getVehicleNo(),
                bookingDetails.getDayOfCharge(),
                bookingDetails.getDayCount()

                );
    }
}
