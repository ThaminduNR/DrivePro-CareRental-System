package com.drivepro.model;

import com.drivepro.entity.Vehicle;
import com.drivepro.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleModel {
    public static boolean addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {

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

    public static ArrayList<Vehicle> getAllVehicle() throws SQLException, ClassNotFoundException {
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

    public static boolean updateVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
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

    public static boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM vehicle WHERE vehicleNo = ?";
        return CrudUtil.execute(sql, vehicleId);
    }
}
