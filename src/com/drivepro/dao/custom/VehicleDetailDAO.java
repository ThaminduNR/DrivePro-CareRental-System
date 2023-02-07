package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.VehicleDTO;
import com.drivepro.dto.VehicleDetailsDTO;

import java.sql.SQLException;

public interface VehicleDetailDAO extends CrudDAO<VehicleDetailsDTO,String> {
    boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException;
    String loadCountOfReserveVehicle() throws SQLException, ClassNotFoundException;
}
