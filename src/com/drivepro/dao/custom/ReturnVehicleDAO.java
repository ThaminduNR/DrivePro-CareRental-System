package com.drivepro.dao.custom;

import com.drivepro.dao.CrudDAO;
import com.drivepro.dto.ReturnVehicleDTO;

import java.sql.SQLException;

public interface ReturnVehicleDAO extends CrudDAO<ReturnVehicleDTO,String> {
    String loadCountOfReturn() throws SQLException, ClassNotFoundException;
}
