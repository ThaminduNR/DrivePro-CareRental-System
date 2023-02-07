package com.drivepro.dao;

import com.drivepro.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory==null) {
            daoFactory = new DAOFactory();
        }

        return daoFactory;
    }

    public SuperDAO getDao(DAOTypes daoTypes){
        switch (daoTypes) {
            case BOOKING:
                return new BookingDAOImpl();
            case BOOKINGDETAILS:
                return new BookingDetailDAOImpl();
            case CASHIER:
                return new CashierDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case RETURNVEHICLE:
                return new ReturnVehicleDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            case VEHICLEDETAILS:
                return new VehicleDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
