package com.drivepro.model;

import com.drivepro.entity.Payment;
import com.drivepro.dao.CrudUtil;

import java.sql.SQLException;

public class PaymentModel {
    public static boolean sendDataPaymentTable(Payment payment) throws SQLException, ClassNotFoundException {
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
}
