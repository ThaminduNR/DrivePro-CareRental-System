package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.CustomerDTO;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO <CustomerDTO,String> {

     String getLastOrderId() throws SQLException, ClassNotFoundException;

     String loadCountOfCustomers() throws SQLException, ClassNotFoundException;


}
