package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;
import com.drivepro.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO extends SuperBO {
    boolean addVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;

    boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException;

    boolean updateVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDTO> getAllVehicle() throws SQLException, ClassNotFoundException;
}
