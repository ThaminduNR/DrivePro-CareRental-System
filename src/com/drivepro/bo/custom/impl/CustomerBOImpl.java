package com.drivepro.bo.custom.impl;

import com.drivepro.bo.Converter;
import com.drivepro.bo.custom.CustomerBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.CustomerDAO;
import com.drivepro.dao.custom.impl.CustomerDAOImpl;
import com.drivepro.dto.CustomerDTO;
import com.drivepro.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

     CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.add(Converter.toCustomerEntity(customerDTO));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(Converter.toCustomerEntity(customerDTO));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> custlist = new ArrayList<>();
        for (Customer cus :all) {
            custlist.add(new CustomerDTO(cus.getCustomerId(),cus.getName(),cus.getAddress(),cus.getContact(),cus.getAge(),cus.getDob()));
        }
        return custlist;
    }

    @Override
    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        return customerDAO.getLastOrderId();
    }


}
