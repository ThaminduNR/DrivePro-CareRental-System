package com.drivepro.model;

import com.drivepro.to.Cashier;
import com.drivepro.to.Customer;
import com.drivepro.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierModel {

    public static boolean addCashier(Cashier cashier) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cashier VALUES(?,?,?,?,?,?)";
        return CrudUtil.execute(sql,

                cashier.getCashierId(),
                cashier.getName(),
                cashier.getAddress(),
                cashier.getContact(),
                cashier.getAge(),
                cashier.getPassword()

        );
    }

    public static boolean updateCustomer(Cashier cashier) throws SQLException, ClassNotFoundException {
        boolean b = CrudUtil.execute("UPDATE cashier SET name=?,address=?,contact=?,age=?,password=? WHERE cashierId=?",

                cashier.getName(),
                cashier.getAddress(),
                cashier.getContact(),
                cashier.getAge(),
                cashier.getPassword(),
                cashier.getCashierId()

        );
        return b;
    }

    public static boolean deleteCashier(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM cashier WHERE cashierId = ?";
        return CrudUtil.execute(sql, id);
    }

    public static ArrayList<Cashier> getAllCashier() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM cashier";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<Cashier> list = new ArrayList<>();

        while (rst.next()){
            list.add(
                new Cashier(
                 rst.getString(1),
                 rst.getString(2),
                 rst.getString(3),
                 rst.getString(4),
                 rst.getInt(5),
                 rst.getString(6)

                ));
        }

        return  list;
    }
}
