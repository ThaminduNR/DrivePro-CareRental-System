package com.drivepro.model;

import com.drivepro.to.VehicleDetails;
import com.drivepro.util.CrudUtil;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDetailModel {

    public static boolean addDetail(VehicleDetails vehicleDetails) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO vehicleDetail VALUES (?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,

                vehicleDetails.getVehicleNo(),
                vehicleDetails.getVehicleName(),
                vehicleDetails.getStartDate(),
                vehicleDetails.getEndDate(),
                vehicleDetails.getDayCount(),
                vehicleDetails.getDayOfCharge(),
                vehicleDetails.getCustId()


                );
    }

    public static ArrayList<VehicleDetails> getAlltobeReseveVehicle() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM vehicleDetail";
        ArrayList<VehicleDetails> vlList = new ArrayList<>();

        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()){
            vlList.add(
                    new VehicleDetails(
                         rst.getString(1),
                         rst.getString(2),
                         rst.getString(3),
                         rst.getString(4),
                         rst.getInt(5),
                         rst.getDouble(6),
                         rst.getString(7)
                    )
            );
        }
        return vlList;
    }

    public static boolean reserveComplete(String vnumber) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM vehicleDetail WHERE vehicleNo = ?";
        return CrudUtil.execute(sql,vnumber);
    }


    public static boolean sendDataReturnTable(VehicleDetails details) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO returnVehicle VALUES(?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,

                details.getVehicleNo(),
                details.getVehicleName(),
                details.getStartDate(),
                details.getEndDate(),
                details.getDayCount(),
                details.getDayOfCharge(),
                details.getCustId()
                );
    }
}
