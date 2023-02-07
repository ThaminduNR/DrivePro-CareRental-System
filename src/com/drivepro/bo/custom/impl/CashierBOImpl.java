package com.drivepro.bo.custom.impl;

import com.drivepro.bo.custom.CashierBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.CashierDAO;
import com.drivepro.dao.custom.impl.CashierDAOImpl;
import com.drivepro.dto.CashierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CashierBOImpl implements CashierBO {
     CashierDAO cashierDAO = (CashierDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.CASHIER);

    @Override
    public boolean addCashier(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException {
        return cashierDAO.add(cashierDTO);
    }

    @Override
    public boolean updateCashier(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException {
        return cashierDAO.update(cashierDTO);
    }

    @Override
    public boolean deleteCashier(String id) throws SQLException, ClassNotFoundException {
        return cashierDAO.delete(id);
    }

    @Override
    public ArrayList<CashierDTO> getAllCashier() throws SQLException, ClassNotFoundException {
        return cashierDAO.getAll();
    }
}
