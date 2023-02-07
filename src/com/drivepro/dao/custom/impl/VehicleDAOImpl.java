package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.VehicleDAO;
import com.drivepro.dto.VehicleDTO;
import com.drivepro.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public boolean add(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO vehicle VALUES(?,?,?,?,?,?,?,?)",

                vehicleDTO.getVehicleNo(),
                vehicleDTO.getName(),
                vehicleDTO.getBrand(),
                vehicleDTO.getDayOfCharge(),
                vehicleDTO.getFuelType(),
                vehicleDTO.getVehicleType(),
                vehicleDTO.getImage(),
                vehicleDTO.getStatus()

        );
    }

    @Override
    public ArrayList<VehicleDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM vehicle");
        ArrayList<VehicleDTO> vehicleList = new ArrayList<>();

        while (rst.next()){
            vehicleList.add(new VehicleDTO (
                    rst.getString("vehicleNo"),
                    rst.getString("name"),
                    rst.getString("brand"),
                    rst.getDouble("dayOfCharge"),
                    rst.getString("fuelType"),
                    rst.getString("vehicleType"),
                    rst.getString("image"),
                    rst.getString("status")


            ));
        }
        return vehicleList;
    }

    @Override
    public boolean update(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicle SET name = ?,brand=?,dayOfCharge=?,fuelType=?,vehicleType=?,image=?,status=? WHERE vehicleNo =?";

        return CrudUtil.execute(sql,


                vehicleDTO.getName(),
                vehicleDTO.getBrand(),
                vehicleDTO.getDayOfCharge(),
                vehicleDTO.getFuelType(),
                vehicleDTO.getVehicleType(),
                vehicleDTO.getImage(),
                vehicleDTO.getStatus(),
                vehicleDTO.getVehicleNo()


        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM vehicle WHERE vehicleNo = ?", id);
    }

    @Override
    public String loadCountOfVehicle() throws SQLException, ClassNotFoundException {
        String count = "";
        String sql = "SELECT COUNT(vehicleNo) FROM vehicle";
        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()) {
            count = rst.getString(1);
        }
        return count;
    }
}
