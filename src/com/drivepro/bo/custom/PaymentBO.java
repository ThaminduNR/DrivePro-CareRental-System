package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;
import com.drivepro.dto.PaymentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentBO extends SuperBO {

    ResultSet generatePaymentId() throws SQLException, ClassNotFoundException;

    boolean addPayments(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException;
}
