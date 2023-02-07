package com.drivepro.model;

import com.drivepro.entity.Booking;
import com.drivepro.dao.CrudUtil;

import java.sql.SQLException;

public class BookingModel {
    public static boolean addbooking(Booking booking) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO booking VALUES (?,?,?,?)";

       return CrudUtil.execute(sql,

                booking.getBookingId(),
                booking.getDate(),
                booking.getTotalCost(),
                booking.getCustId()

                );

    }

 /*   public static String getLastOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT bookingId FROM booking ORDER BY bookingId DESC LIMIT 1");
        return rst.next() ? rst.getString("bookingId"):null;
    }*/
}
