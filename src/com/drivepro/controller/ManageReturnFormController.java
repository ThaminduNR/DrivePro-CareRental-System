package com.drivepro.controller;

import com.drivepro.bo.BOFactory;
import com.drivepro.bo.BOTypes;
import com.drivepro.bo.custom.ReturnVehicleBO;
import com.drivepro.bo.custom.impl.ReturnVehicleBOImpl;
import com.drivepro.dto.ReturnVehicleDTO;
import com.drivepro.view.tm.ReturnVehicleTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageReturnFormController {

    public TableView<ReturnVehicleTM> tblReturn;

    public TableColumn<ReturnVehicleTM, String> colnumber;
    public TableColumn<ReturnVehicleTM, String> colName;
    public TableColumn<ReturnVehicleTM, String> colsDate;
    public TableColumn<ReturnVehicleTM, String> colEndDate;
    public TableColumn<ReturnVehicleTM, String> colDayCount;
    public TableColumn<ReturnVehicleTM, String> colDacharge;
    public TableColumn<ReturnVehicleTM, String> colcustId;

    private final ReturnVehicleBO returnVehicleBO = (ReturnVehicleBO) BOFactory.getBoFactory().getBO(BOTypes.RETURNVEHICLE);

    public void initialize() {
        setValueFactory();
        loadreturnData();
    }

    public void loadreturnData() {
        ObservableList<ReturnVehicleTM> list = FXCollections.observableArrayList();
        try {
            ArrayList<ReturnVehicleDTO> returnDetailList = returnVehicleBO.getAllReturns();
            for (ReturnVehicleDTO r : returnDetailList) {
                ReturnVehicleTM rtm = new ReturnVehicleTM(r.getVehicleNo(), r.getVehicleName(), r.getStartDate(), r.getEndDate(), r.getDayCount(), r.getDayOfCharge(), r.getCustId());
                list.add(rtm);
            }
            tblReturn.setItems(list);
            tblReturn.refresh();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setValueFactory() {
        colnumber.setCellValueFactory(new PropertyValueFactory<ReturnVehicleTM, String>("vehicleNo"));
        colName.setCellValueFactory(new PropertyValueFactory<ReturnVehicleTM, String>("vehicleName"));
        colsDate.setCellValueFactory(new PropertyValueFactory<ReturnVehicleTM, String>("startDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<ReturnVehicleTM, String>("endDate"));
        colDayCount.setCellValueFactory(new PropertyValueFactory<ReturnVehicleTM, String>("dayCount"));
        colDacharge.setCellValueFactory(new PropertyValueFactory<ReturnVehicleTM, String>("dayOfCharge"));
        colcustId.setCellValueFactory(new PropertyValueFactory<ReturnVehicleTM, String>("CustId"));
    }
}
