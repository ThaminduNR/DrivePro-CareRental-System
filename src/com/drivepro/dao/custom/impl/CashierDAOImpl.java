package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.CashierDAO;
import com.drivepro.dto.CashierDTO;
import com.drivepro.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierDAOImpl implements CashierDAO {
    @Override
    public boolean add(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cashier VALUES(?,?,?,?,?,?)";
        return CrudUtil.execute(sql,

                cashierDTO.getCashierId(),
                cashierDTO.getName(),
                cashierDTO.getAddress(),
                cashierDTO.getContact(),
                cashierDTO.getAge(),
                cashierDTO.getPassword()

        );
    }

    @Override
    public ArrayList<CashierDTO> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM cashier";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<CashierDTO> list = new ArrayList<>();

        while (rst.next()){
            list.add(
                    new CashierDTO(
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
    public boolean update(CashierDTO cashierDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE cashier SET name=?,address=?,contact=?,age=?,password=? WHERE cashierId=?",

                cashierDTO.getName(),
                cashierDTO.getAddress(),
                cashierDTO.getContact(),
                cashierDTO.getAge(),
                cashierDTO.getPassword(),
                cashierDTO.getCashierId()

        );

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM cashier WHERE cashierId = ?";
        return CrudUtil.execute(sql, id);
    }
}
