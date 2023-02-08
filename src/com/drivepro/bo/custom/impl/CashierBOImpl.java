package com.drivepro.bo.custom.impl;

import com.drivepro.bo.Converter;
import com.drivepro.bo.custom.CashierBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.CashierDAO;
import com.drivepro.dao.custom.impl.CashierDAOImpl;
import com.drivepro.dto.CashierDTO;
import com.drivepro.entity.Cashier;

import java.sql.SQLException;
import java.util.ArrayList;

public class CashierBOImpl implements CashierBO {
     CashierDAO cashierDAO = (CashierDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.CASHIER);

    @Override
    public boolean addCashier(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException {
        return cashierDAO.add(Converter.toCashierEntity(cashierDTO));
    }

    @Override
    public boolean updateCashier(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException {
        return cashierDAO.update(Converter.toCashierEntity(cashierDTO));
    }

    @Override
    public boolean deleteCashier(String id) throws SQLException, ClassNotFoundException {
        return cashierDAO.delete(id);
    }

    @Override
    public ArrayList<CashierDTO> getAllCashier() throws SQLException, ClassNotFoundException {
        ArrayList<Cashier> all = cashierDAO.getAll();
        ArrayList<CashierDTO> cashierList =new ArrayList<>();
        for (Cashier cashier:all) {
            cashierList.add( new CashierDTO(cashier.getCashierId(),cashier.getName(),cashier.getAddress(),cashier.getContact(),cashier.getAge(),cashier.getPassword()));
        }
        return cashierList;
    }
}
