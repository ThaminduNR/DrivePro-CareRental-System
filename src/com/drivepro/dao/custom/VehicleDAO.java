package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.VehicleDTO;
import com.drivepro.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<Vehicle,String> {

    String loadCountOfVehicle() throws SQLException, ClassNotFoundException;
}
