package com.drivepro.bo;

import com.drivepro.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory(){
        if (boFactory==null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes) {
            case BOOKINGORDER:
                return new BookingOrderBOImpl();
            case CASHIER:
                return new CashierBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case HOME:
                return new HomeBOImpl();
            case MAINDBOARD:
                return new MainDBoardBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case RETURNVEHICLE:
                return new ReturnVehicleBOImpl();
            case VEHICLE:
                return new VehicleBOImpl();
            case VEHICLEDETAIL:
                return new VehicleDetailBOImpl();
            default:
                return null;
        }
    }
}
