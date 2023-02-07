package com.drivepro.bo.custom.impl;


import com.drivepro.bo.custom.VehicleBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.VehicleDAO;
import com.drivepro.dao.custom.impl.VehicleDAOImpl;
import com.drivepro.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {
    private final VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.VEHICLE);

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.add(vehicleDTO);
    }

    @Override
    public boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
       return vehicleDAO.delete(vehicleId);
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(vehicleDTO);
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getAll();
    }
}
