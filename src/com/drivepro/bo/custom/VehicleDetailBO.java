package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;
import com.drivepro.dto.ReturnVehicleDTO;
import com.drivepro.dto.VehicleDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDetailBO extends SuperBO {
    boolean addReservedCompleteVehicle(ReturnVehicleDTO returnVehicleDTO) throws SQLException, ClassNotFoundException;

    boolean deleteHandOverVehicle(String vnumber) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDetailsDTO> getAllReservedVehicle() throws SQLException, ClassNotFoundException;

    boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException;
}
