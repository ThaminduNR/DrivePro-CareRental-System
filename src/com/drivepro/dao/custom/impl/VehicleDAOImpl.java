package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.VehicleDAO;
import com.drivepro.dto.VehicleDTO;
import com.drivepro.dao.CrudUtil;
import com.drivepro.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public boolean add(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO vehicle VALUES(?,?,?,?,?,?,?,?)",

                vehicle.getVehicleNo(),
                vehicle.getName(),
                vehicle.getBrand(),
                vehicle.getDayOfCharge(),
                vehicle.getFuelType(),
                vehicle.getVehicleType(),
                vehicle.getImage(),
                vehicle.getStatus()

        );
    }

    @Override
    public ArrayList<Vehicle> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM vehicle");
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        while (rst.next()){
            vehicleList.add(new Vehicle (
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
    public boolean update(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicle SET name = ?,brand=?,dayOfCharge=?,fuelType=?,vehicleType=?,image=?,status=? WHERE vehicleNo =?";

        return CrudUtil.execute(sql,


                vehicle.getName(),
                vehicle.getBrand(),
                vehicle.getDayOfCharge(),
                vehicle.getFuelType(),
                vehicle.getVehicleType(),
                vehicle.getImage(),
                vehicle.getStatus(),
                vehicle.getVehicleNo()


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
