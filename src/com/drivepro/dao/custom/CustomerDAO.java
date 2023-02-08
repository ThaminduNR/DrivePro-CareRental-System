package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.CustomerDTO;
import com.drivepro.entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO <Customer,String> {

     String getLastOrderId() throws SQLException, ClassNotFoundException;

     String loadCountOfCustomers() throws SQLException, ClassNotFoundException;


}
