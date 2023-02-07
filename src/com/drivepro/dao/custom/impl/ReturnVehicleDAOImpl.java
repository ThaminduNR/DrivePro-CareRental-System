package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.ReturnVehicleDAO;
import com.drivepro.dto.ReturnVehicleDTO;
import com.drivepro.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnVehicleDAOImpl implements ReturnVehicleDAO {
    @Override
    public boolean add(ReturnVehicleDTO returnVehicleDTO) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO returnVehicle VALUES(?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,

                returnVehicleDTO.getVehicleNo(),
                returnVehicleDTO.getVehicleName(),
                returnVehicleDTO.getStartDate(),
                returnVehicleDTO.getEndDate(),
                returnVehicleDTO.getDayCount(),
                returnVehicleDTO.getDayOfCharge(),
                returnVehicleDTO.getCustId()
        );
    }

    @Override
    public ArrayList<ReturnVehicleDTO> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM returnVehicle";
        ArrayList<ReturnVehicleDTO> returnList = new ArrayList<>();

        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()){
            returnList.add(
                    new ReturnVehicleDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getInt(5),
                            rst.getDouble(6),
                            rst.getString(7)

                    ));

        }

        return returnList;
    }


    @Override
    public boolean update(ReturnVehicleDTO returnVehicleDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String loadCountOfReturn() throws SQLException, ClassNotFoundException {
        String count = "";
        String sql = "SELECT COUNT(vehicleNo) FROM returnVehicle";
        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()) {
            count = rst.getString(1);
        }
        return count;
    }
}
