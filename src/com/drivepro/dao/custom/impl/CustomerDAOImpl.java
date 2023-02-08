package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.CustomerDAO;
import com.drivepro.dto.CustomerDTO;
import com.drivepro.dao.CrudUtil;
import com.drivepro.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
         return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?)",

                 customer.getCustomerId(),
                 customer.getName(),
                 customer.getAddress(),
                 customer.getContact(),
                 customer.getAge(),
                 customer.getDob()


        );
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> customerList = new ArrayList<>();

        while (rst.next()) {
            customerList.add(
                    new Customer(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getInt(5),
                            rst.getString(6)
                    ));

        }

        return customerList;
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE customer SET name=?,address=?,contact=?,age=?,dob=? WHERE customerId=?",

                customer.getName(),
                customer.getAddress(),
                customer.getContact(),
                customer.getAge(),
                customer.getDob(),
                customer.getCustomerId()

        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM customer WHERE customerId = ?", id);
    }

    @Override
    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1");
        return rst.next() ? rst.getString("customerId") : null;
    }

    @Override
    public String loadCountOfCustomers() throws SQLException, ClassNotFoundException {
        String count = "";
        String sql = "SELECT COUNT(customerId) FROM customer";
        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()) {
            count = rst.getString(1);
        }
        return count;
    }

}
