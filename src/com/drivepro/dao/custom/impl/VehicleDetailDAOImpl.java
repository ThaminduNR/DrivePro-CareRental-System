package com.drivepro.dao.custom.impl;

import com.drivepro.dao.custom.VehicleDetailDAO;
import com.drivepro.dto.VehicleDetailsDTO;
import com.drivepro.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDetailDAOImpl implements VehicleDetailDAO {

    @Override
    public boolean add(VehicleDetailsDTO vehicleDetailsDTO) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO vehicleDetail VALUES (?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,

                vehicleDetailsDTO.getVehicleNo(),
                vehicleDetailsDTO.getVehicleName(),
                vehicleDetailsDTO.getStartDate(),
                vehicleDetailsDTO.getEndDate(),
                vehicleDetailsDTO.getDayCount(),
                vehicleDetailsDTO.getDayOfCharge(),
                vehicleDetailsDTO.getCustId()


        );
    }

    @Override
    public ArrayList<VehicleDetailsDTO> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM vehicleDetail";
        ArrayList<VehicleDetailsDTO> vlList = new ArrayList<>();

        ResultSet rst = CrudUtil.execute(sql);
        while (rst.next()){
            vlList.add(
                    new VehicleDetailsDTO(
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

    @Override
    public boolean update(VehicleDetailsDTO vehicleDetailsDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String vnumber) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM vehicleDetail WHERE vehicleNo = ?";
        return CrudUtil.execute(sql,vnumber);
    }

    @Override
    public boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException {
        String sql="UPDATE vehicle SET  status = 'Available' WHERE vehicleNo = ?";
        return CrudUtil.execute(sql, id);
    }

    @Override
    public String loadCountOfReserveVehicle() throws SQLException, ClassNotFoundException {
        String count = "";
        String sql = "SELECT COUNT(vehicleNo) FROM vehicleDetail";
        ResultSet rst = CrudUtil.execute(sql);

        while (rst.next()) {
            count = rst.getString(1);
        }
        return count;
    }
}
