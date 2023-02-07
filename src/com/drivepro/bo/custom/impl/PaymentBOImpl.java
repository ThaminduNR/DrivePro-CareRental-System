package com.drivepro.bo.custom.impl;

import com.drivepro.bo.custom.PaymentBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.PaymentDAO;
import com.drivepro.dao.custom.impl.PaymentDAOImpl;
import com.drivepro.dto.PaymentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {
     PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.PAYMENT);

    @Override
    public ResultSet generatePaymentId() throws SQLException, ClassNotFoundException {
        return paymentDAO.generatePaymentId();
    }

    @Override
    public boolean addPayments(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
        return paymentDAO.add(paymentDTO);
    }
}
