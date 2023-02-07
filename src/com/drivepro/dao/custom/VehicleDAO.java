package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<VehicleDTO,String> {

    String loadCountOfVehicle() throws SQLException, ClassNotFoundException;
}
