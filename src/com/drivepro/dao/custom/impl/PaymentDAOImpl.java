package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.PaymentDAO;
import com.drivepro.dto.PaymentDTO;
import com.drivepro.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO payment VALUES(?,?,?,?,?,?,?)";

        return   CrudUtil.execute(sql,

                paymentDTO.getPaymentId(),
                paymentDTO.getCustId(),
                paymentDTO.getPaydate(),
                paymentDTO.getPayTime(),
                paymentDTO.getVehicleNo(),
                paymentDTO.getTotalPay(),
                paymentDTO.getMethod()

        );
    }

    @Override
    public ArrayList<PaymentDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
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
