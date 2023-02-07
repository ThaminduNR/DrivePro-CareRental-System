package com.drivepro.bo.custom;

import com.drivepro.bo.SuperBO;
import com.drivepro.dto.ReturnVehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReturnVehicleBO extends SuperBO {
    ArrayList<ReturnVehicleDTO> getAllReturns() throws SQLException, ClassNotFoundException;
}
