package com.drivepro.bo;

import com.drivepro.dto.*;
import com.drivepro.entity.*;

public class Converter {
    public static Customer toCustomerEntity(CustomerDTO dto){
        return new Customer(dto.getCustomerId(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getAge(), dto.getDob());
    }

    public static CustomerDTO fromCustomerEntity(Customer cus){
        return new CustomerDTO(cus.getCustomerId(), cus.getName(), cus.getAddress(), cus.getContact(), cus.getAge(), cus.getDob());
    }

    public static Booking toBookingEntity(BookingDTO dto){
        return new Booking(dto.getBookingId(),dto.getDate(),dto.getTotalCost(),dto.getCustId());
    }

    public static VehicleDetails toVehicleDetailsEntity(VehicleDetailsDTO dto){
        return new VehicleDetails(dto.getVehicleNo(),dto.getVehicleName(),dto.getStartDate(),dto.getEndDate(),dto.getDayCount(),dto.getDayOfCharge(),dto.getCustId());
    }

    public static BookingDetails toBookingDetailsEntity(BookingDetailsDTO dto) {
        return new BookingDetails(dto.getBookingId(),dto.getVehicleNo(),dto.getDayCount(),dto.getDayOfCharge());
    }


    public static Cashier toCashierEntity(CashierDTO dto) {
        return new Cashier(dto.getCashierId(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getAge(),dto.getPassword());
    }

    public static Payment toPaymentEntity(PaymentDTO dto) {
        return new Payment(dto.getPaymentId(),dto.getCustId(),dto.getPaydate(), dto.getPayTime(), dto.getVehicleNo(), dto.getTotalPay(), dto.getMethod());
    }


    public static Vehicle toVehicleEntity(VehicleDTO dto) {
        return new Vehicle(dto.getVehicleNo(),dto.getName(),dto.getBrand(),dto.getDayOfCharge(),dto.getFuelType(),dto.getVehicleType(),dto.getImage(), dto.getStatus());
    }

    public static ReturnVehicle toReturnVehicleEntity(ReturnVehicleDTO dto) {

        return new ReturnVehicle(dto.getVehicleNo(),dto.getVehicleName(),dto.getStartDate(),dto.getEndDate(),dto.getDayCount(),dto.getDayOfCharge(),dto.getCustId());
    }
}
