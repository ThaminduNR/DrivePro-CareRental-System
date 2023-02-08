package com.drivepro.bo.custom.impl;


import com.drivepro.bo.Converter;
import com.drivepro.bo.custom.VehicleBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.VehicleDAO;
import com.drivepro.dao.custom.impl.VehicleDAOImpl;
import com.drivepro.dto.VehicleDTO;
import com.drivepro.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {
    private final VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.VEHICLE);

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.add(Converter.toVehicleEntity(vehicleDTO));
    }

    @Override
    public boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
       return vehicleDAO.delete(vehicleId);
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(Converter.toVehicleEntity(vehicleDTO));
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> all = vehicleDAO.getAll();

        ArrayList<VehicleDTO> allVehicle = new ArrayList<>();

        for (Vehicle vh:all) {
            allVehicle.add(new VehicleDTO(vh.getVehicleNo(),vh.getName(),vh.getBrand(),vh.getDayOfCharge(),vh.getFuelType(),vh.getVehicleType(),vh.getImage(),vh.getStatus()));
        }
        return allVehicle;
    }
}
