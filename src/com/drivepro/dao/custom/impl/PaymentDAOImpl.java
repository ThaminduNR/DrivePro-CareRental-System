package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.PaymentDAO;
import com.drivepro.dto.PaymentDTO;
import com.drivepro.dao.CrudUtil;
import com.drivepro.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(Payment payment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO payment VALUES(?,?,?,?,?,?,?)";

        return   CrudUtil.execute(sql,

                payment.getPaymentId(),
                payment.getCustId(),
                payment.getPaydate(),
                payment.getPayTime(),
                payment.getVehicleNo(),
                payment.getTotalPay(),
                payment.getMethod()

        );
    }

    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Payment payment) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet generatePaymentId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT paymentId FROM `payment` ORDER BY paymentId DESC LIMIT 1";
        return CrudUtil.execute(sql);
    }
}
