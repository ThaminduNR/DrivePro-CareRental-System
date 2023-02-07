package com.drivepro.model;

import com.drivepro.db.DBConnection;
import com.drivepro.entity.Customer;
import com.drivepro.dao.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerModel {

    public static boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?)",

                customer.getCustomerId(),
                customer.getName(),
                customer.getAddress(),
                customer.getContact(),
                customer.getAge(),
                customer.getDob()


                );
    }

    public static ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {

        String sql ="SELECT * FROM customer";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<Customer> customerList = new ArrayList<>();

        while (rst.next()){
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

    public static boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        boolean b = CrudUtil.execute("UPDATE customer SET name=?,address=?,contact=?,age=?,dob=? WHERE customerId=?",

                customer.getName(),
                customer.getAddress(),
                customer.getContact(),
                customer.getAge(),
                customer.getDob(),
                customer.getCustomerId()

        );
        return b;
    }


    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE customerId = ?";
        return CrudUtil.execute(sql,id);
    }

    public static String getLastOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1");
        return rst.next() ? rst.getString("customerId"):null;
    }

}
