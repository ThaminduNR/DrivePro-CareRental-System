package com.drivepro.model;

import com.drivepro.to.ReturnVehicle;
import com.drivepro.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnVehicleModel {
    public static ArrayList<ReturnVehicle> loadDataReturnTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM returnVehicle";
        ArrayList<ReturnVehicle> returnList = new ArrayList<>();

        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()){
            returnList.add(
                    new ReturnVehicle(
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


}
