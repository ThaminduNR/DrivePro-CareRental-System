package com.drivepro.bo.custom.impl;

import com.drivepro.bo.custom.ReturnVehicleBO;
import com.drivepro.dao.DAOFactory;
import com.drivepro.dao.DAOTypes;
import com.drivepro.dao.custom.ReturnVehicleDAO;
import com.drivepro.dao.custom.impl.ReturnVehicleDAOImpl;
import com.drivepro.dto.ReturnVehicleDTO;
import com.drivepro.entity.ReturnVehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnVehicleBOImpl implements ReturnVehicleBO {

     ReturnVehicleDAO returnVehicleDAO = (ReturnVehicleDAO) DAOFactory.getDaoFactory().getDao(DAOTypes.RETURNVEHICLE);

    @Override
    public ArrayList<ReturnVehicleDTO> getAllReturns() throws SQLException, ClassNotFoundException {
        ArrayList<ReturnVehicle> all = returnVehicleDAO.getAll();
        ArrayList<ReturnVehicleDTO> allReturn = new ArrayList<>();

        for (ReturnVehicle rv:all) {
            allReturn.add(new ReturnVehicleDTO(rv.getVehicleNo(),rv.getVehicleName(),rv.getStartDate(),rv.getEndDate(),rv.getDayCount(),rv.getDayOfCharge(),rv.getCustId()));
        }
        return allReturn;
    }
}
