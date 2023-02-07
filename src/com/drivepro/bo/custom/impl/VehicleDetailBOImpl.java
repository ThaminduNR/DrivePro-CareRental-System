package com.drivepro.bo.custom.impl;

import com.drivepro.bo.custom.VehicleDetailBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.ReturnVehicleDAO;
import com.drivepro.dao.custom.VehicleDetailDAO;
import com.drivepro.dao.custom.impl.ReturnVehicleDAOImpl;
import com.drivepro.dao.custom.impl.VehicleDetailDAOImpl;
import com.drivepro.dto.ReturnVehicleDTO;
import com.drivepro.dto.VehicleDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDetailBOImpl implements VehicleDetailBO {

    private final ReturnVehicleDAO returnVehicleDAO = (ReturnVehicleDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.RETURNVEHICLE);
    private final VehicleDetailDAO vehicleDetailDAO = (VehicleDetailDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.VEHICLEDETAILS);

    @Override
    public boolean addReservedCompleteVehicle(ReturnVehicleDTO returnVehicleDTO) throws SQLException, ClassNotFoundException {
        return returnVehicleDAO.add(returnVehicleDTO);
    }

    @Override
    public boolean deleteHandOverVehicle(String vnumber) throws SQLException, ClassNotFoundException {
        return vehicleDetailDAO.delete(vnumber);
    }

    @Override
    public ArrayList<VehicleDetailsDTO> getAllReservedVehicle() throws SQLException, ClassNotFoundException {
        return vehicleDetailDAO.getAll();
    }

    @Override
    public boolean changeVehicleState(String id) throws SQLException, ClassNotFoundException {
        return vehicleDetailDAO.changeVehicleState(id);
    }
}
