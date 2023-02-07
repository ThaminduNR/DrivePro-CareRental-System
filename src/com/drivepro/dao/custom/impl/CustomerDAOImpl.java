package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.CustomerDAO;
import com.drivepro.dto.CustomerDTO;
import com.drivepro.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
         return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?)",

                customerDTO.getCustomerId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContact(),
                customerDTO.getAge(),
                customerDTO.getDob()


        );
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer");
        ArrayList<CustomerDTO> customerList = new ArrayList<>();

        while (rst.next()) {
            customerList.add(
                    new CustomerDTO(
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
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE customer SET name=?,address=?,contact=?,age=?,dob=? WHERE customerId=?",

                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContact(),
                customerDTO.getAge(),
                customerDTO.getDob(),
                customerDTO.getCustomerId()

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
