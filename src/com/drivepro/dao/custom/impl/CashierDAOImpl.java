package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.CashierDAO;
import com.drivepro.dto.CashierDTO;
import com.drivepro.dao.CrudUtil;
import com.drivepro.entity.Cashier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierDAOImpl implements CashierDAO {
    @Override
    public boolean add(Cashier cashier) throws SQLException, ClassNotFoundException {
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

    @Override
    public ArrayList<Cashier> getAll() throws SQLException, ClassNotFoundException {
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

    @Override
    public boolean update(Cashier cashier) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE cashier SET name=?,address=?,contact=?,age=?,password=? WHERE cashierId=?",

                cashier.getName(),
                cashier.getAddress(),
                cashier.getContact(),
                cashier.getAge(),
                cashier.getPassword(),
                cashier.getCashierId()

        );

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM cashier WHERE cashierId = ?";
        return CrudUtil.execute(sql, id);
    }
}
