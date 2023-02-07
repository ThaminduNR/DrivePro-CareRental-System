package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.PaymentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<PaymentDTO,String> {
    ResultSet generatePaymentId() throws SQLException, ClassNotFoundException;
}
