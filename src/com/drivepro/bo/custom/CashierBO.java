package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;
import com.drivepro.dto.CashierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CashierBO extends SuperBO {
    boolean addCashier(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException;

    boolean updateCashier(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException;

    boolean deleteCashier(String id) throws SQLException, ClassNotFoundException;

    ArrayList<CashierDTO> getAllCashier() throws SQLException, ClassNotFoundException;

}
