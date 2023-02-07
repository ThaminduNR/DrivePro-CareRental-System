package com.drivepro.bo.custom.impl;

import com.drivepro.bo.custom.BookingOrderBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.BookingDAO;
import com.drivepro.dao.custom.BookingDetailDAO;
import com.drivepro.dao.custom.VehicleDetailDAO;
import com.drivepro.dao.custom.impl.BookingDAOImpl;
import com.drivepro.dao.custom.impl.BookingDetailDAOImpl;
import com.drivepro.dao.custom.impl.VehicleDetailDAOImpl;
import com.drivepro.db.DBConnection;
import com.drivepro.dto.BookingDTO;
import com.drivepro.dto.BookingDetailsDTO;
import com.drivepro.dto.VehicleDetailsDTO;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingOrderBOImpl implements BookingOrderBO {



    private final BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.BOOKING);
    private final VehicleDetailDAO vehicleDetailDAO = (VehicleDetailDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.VEHICLEDETAILS);
    private final BookingDetailDAO bookingDetailDAO = (BookingDetailDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.BOOKINGDETAILS);

    @Override
    public boolean bookingOrder(String bookingId, String date, double totalCost, String custId, String num, String name, String sDate, String eDate, int dayCount, double dayCharge) throws SQLException {

        BookingDTO bookingDTO = new BookingDTO(bookingId, date, totalCost, custId);
        VehicleDetailsDTO vehicleDetailsDTO = new VehicleDetailsDTO(num, name, sDate, eDate, dayCount, dayCharge, custId);
        BookingDetailsDTO bookingDetailsDTO = new BookingDetailsDTO(bookingId, num, dayCount, dayCharge);

        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isAdded = bookingDAO.add(bookingDTO);
            if (isAdded) {
                System.out.println("Booking Added ok");
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            boolean isAdded = vehicleDetailDAO.add(vehicleDetailsDTO);
            if (isAdded) {
                System.out.println("vehicle Detail Added");
            } else {

                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //send data to BookingDetails table
        try {
            boolean isAdded = bookingDetailDAO.add(bookingDetailsDTO);
            if (isAdded) {
                connection.commit();

            } else {
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        return true;
    }

    @Override
    public boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException {
         return bookingDAO.changeVehicleState(id);
    }

    @Override
    public ObservableList<String> loadCustomerId() throws SQLException, ClassNotFoundException {
        return bookingDAO.loadCustomerId();
    }

    @Override
    public ObservableList<String> loadVehicleNumber() throws SQLException, ClassNotFoundException {
        return bookingDAO.loadVehicleNumber();
    }

    @Override
    public ResultSet ChangeStateVehicleNo(String num) throws SQLException, ClassNotFoundException {
        return bookingDAO.ChangeStateVehicleNo(num);
    }

    @Override
    public ResultSet changeStateCustID(String cust) throws SQLException, ClassNotFoundException {
       return bookingDAO.changeStateCustID(cust);
    }

    @Override
    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        return bookingDAO.getLastOrderId();
    }

}

