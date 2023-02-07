package com.drivepro.bo.custom.impl;

import com.drivepro.bo.custom.MainDBoardBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.*;
import com.drivepro.dao.custom.impl.*;

import java.sql.SQLException;

public class MainDBoardBOImpl implements MainDBoardBO {

    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.VEHICLE);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.CUSTOMER);
    BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.BOOKING);
    ReturnVehicleDAO returnVehicleDAO = (ReturnVehicleDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.RETURNVEHICLE);
    VehicleDetailDAO vehicleDetailDAO = (VehicleDetailDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.VEHICLEDETAILS);

    @Override
    public String loadCountOfVehicle() throws SQLException, ClassNotFoundException {
       return vehicleDAO.loadCountOfVehicle();
    }

    @Override
    public String loadCountOfCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.loadCountOfCustomers();
    }

    @Override
    public String loadCountOfBooking() throws SQLException, ClassNotFoundException {
        return bookingDAO.loadCountOfBooking();
    }

    @Override
    public String loadCountOfReturn() throws SQLException, ClassNotFoundException {
        return returnVehicleDAO.loadCountOfReturn();
    }

    @Override
    public String loadCountOfReserveVehicle() throws SQLException, ClassNotFoundException {
        return vehicleDetailDAO.loadCountOfReserveVehicle();
    }
}
