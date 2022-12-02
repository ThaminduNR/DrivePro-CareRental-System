package com.drivepro.controller;

import com.drivepro.model.VehicleDetailModel;
import com.drivepro.to.VehicleDetails;
import com.drivepro.util.CrudUtil;
import com.drivepro.util.Navigation;
import com.drivepro.util.Routes;
import com.drivepro.view.tm.VehicleDetailTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageVehicleDetailsFormController {


    public TextField txtVehicleNo;
    public TextField txtVehicleName;
    public TextField txtSdate;
    public TextField txtEdate;
    public TextField txtDayCount;
    public TextField txtDayOfCharge;
    public TextField txtCustId;


    public TableView<VehicleDetailTM> tblReserve;
    public TableColumn colvNumber;
    public TableColumn colName;
    public TableColumn colStartDate;
    public TableColumn colEnddate;
    public TableColumn coldayCount;
    public TableColumn colDayCharge;
    public TableColumn colCustomerID;
    public AnchorPane vDetailContext;

    public void initialize(){
        setValueFactory();
        loadAllDataToTable();
        AddListener();
        tblReserve.refresh();
    }


    public void reservedCompleteOnAction(ActionEvent actionEvent) {
        String vnumber = txtVehicleNo.getText();
        String vname = txtVehicleName.getText();
        String sdate = txtSdate.getText();
        String edate = txtEdate.getText();
        int daycount = Integer.parseInt(txtDayCount.getText());
        double daycharge = Double.parseDouble(txtDayOfCharge.getText());
        String custId = txtCustId.getText();

        VehicleDetails details = new VehicleDetails(vnumber,vname,sdate,edate,daycount,daycharge,custId);
        try {
            boolean b = VehicleDetailModel.sendDataReturnTable(details);
            if (b){
                System.out.println("return send");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //complete reserve

        try {
            boolean deleted = VehicleDetailModel.reserveComplete(vnumber);
            if (deleted){
                new Alert(Alert.AlertType.INFORMATION,"Reserved Success").show();
                changeVehicleState(vnumber);
                clearText();
                Navigation.navigatePane(Routes.RESERVED,vDetailContext);
            }else{
                new Alert(Alert.AlertType.INFORMATION,"Reserved failed").show();
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        //set values return tables
        /*VehicleDetails details = new VehicleDetails(vnumber,vname,sdate,edate,daycount,daycharge,custId);
        try {
            boolean b = VehicleDetailModel.sendDataReturnTable(details);
            if (b){
                System.out.println("return send");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
*/
    }

    private void loadAllDataToTable(){
        ObservableList<VehicleDetailTM> list = FXCollections.observableArrayList();
        try {
            ArrayList<VehicleDetails> allToBeReservedVehicle = VehicleDetailModel.getAlltobeReseveVehicle();
            for (VehicleDetails vehicle :allToBeReservedVehicle) {
                VehicleDetailTM vTM = new VehicleDetailTM(vehicle.getVehicleNo(),vehicle.getVehicleName(),vehicle.getStartDate(),vehicle.getEndDate(),vehicle.getDayCount(),vehicle.getDayOfCharge(),vehicle.getCustId() );
                list.add(vTM);
            }
            tblReserve.setItems(list);
            tblReserve.refresh();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  void setValueFactory(){
        colvNumber.setCellValueFactory(new PropertyValueFactory<VehicleDetailTM,String>("vehicleNo"));
        colName.setCellValueFactory(new PropertyValueFactory<VehicleDetailTM,String>("vehicleName"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<VehicleDetailTM,String>("startDate"));
        colEnddate.setCellValueFactory(new PropertyValueFactory<VehicleDetailTM,String>("endDate"));
        coldayCount.setCellValueFactory(new PropertyValueFactory<VehicleDetailTM,String>("dayCount"));
        colDayCharge.setCellValueFactory(new PropertyValueFactory<VehicleDetailTM,String>("dayOfCharge"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<VehicleDetailTM,String>("CustId"));
    }

    public void AddListener(){
        tblReserve.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null) {
                setDataToTextField(newValue);
            }
        });
    }

    private void setDataToTextField(VehicleDetailTM vtm) {
        txtVehicleNo.setText(vtm.getVehicleNo());
        txtVehicleName.setText(vtm.getVehicleName());
        txtSdate.setText(vtm.getStartDate());
        txtEdate.setText(vtm.getEndDate());
        txtDayCount.setText(String.valueOf(vtm.getDayCount()));
        txtDayOfCharge.setText(String.valueOf(vtm.getDayOfCharge()));
        txtCustId.setText(vtm.getCustId());
    }

    public void clearText(){
        txtVehicleNo.clear();
        txtVehicleName.clear();
        txtSdate.clear();
        txtEdate.clear();
        txtDayOfCharge.clear();
        txtDayCount.clear();
        txtCustId.clear();
    }

    public void changeVehicleState(String id) throws SQLException {
        String sql="UPDATE vehicle SET  status = 'Available' WHERE vehicleNo = ?";
        try {
            boolean isUpdate = CrudUtil.execute(sql, id);
            if (isUpdate){
                System.out.println("Available Up date");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
