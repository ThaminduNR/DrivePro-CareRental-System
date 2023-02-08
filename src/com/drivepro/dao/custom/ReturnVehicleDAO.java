package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.ReturnVehicleDTO;
import com.drivepro.entity.ReturnVehicle;

import java.sql.SQLException;

public interface ReturnVehicleDAO extends CrudDAO<ReturnVehicle,String> {
    String loadCountOfReturn() throws SQLException, ClassNotFoundException;
}
