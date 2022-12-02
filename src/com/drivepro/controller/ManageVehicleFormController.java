package com.drivepro.controller;

import com.drivepro.model.VehicleModel;
import com.drivepro.to.Vehicle;
import com.drivepro.view.tm.VehicleTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageVehicleFormController {
    public TextField txtVehicleNo;
    public TextField txtVehicleName;
    public TextField txtDayOfCharge;
    public TextField txtBrand;
    public ImageView imgvehicle;
    public TextField txtVehicleType;
    public Button btnBrows;
    public ComboBox<String> cmbFuelType;
    public ComboBox<String> cmbstatus;

    public TableView<VehicleTM> vehicleTable;

    public TableColumn<VehicleTM, String> colVehicleNo;
    public TableColumn<VehicleTM, String> colName;
    public TableColumn<VehicleTM, String> colBrand;
    public TableColumn<VehicleTM, String> colDayCharge;
    public TableColumn<VehicleTM, String> colfuelType;
    public TableColumn<VehicleTM, String> colVType;
    public TableColumn<VehicleTM, String> colimage;
    public TableColumn<VehicleTM, String> colStatus;

    public AnchorPane mangeStage;
    public AnchorPane mainVehiclePane;

    public String imageName;



    public void initialize(){
        setValueFactory();
        setTableData();
        loadStatus();
        loadFuelType();
        AddListener();

    }
    //Fuel type and status is predefined, so we must add the combobox
    public void loadStatus(){
        ObservableList<String> statusList = FXCollections.observableArrayList("Available","Unavailable");
        cmbstatus.setItems(statusList);
    }
    private void loadFuelType() {
        ObservableList<String> fuelList = FXCollections.observableArrayList("Petrol","Diesel");
        cmbFuelType.setItems(fuelList);
    }

    //Image browser Mouse click Action
    public void openBrowseImageOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");

        fileChooser.getExtensionFilters().addAll(extFilterPNG, extFilterJPG);
        File file = fileChooser.showOpenDialog(null);
        imageName = file.getAbsolutePath();

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgvehicle.setImage(image);
        } catch (IOException ignored) {

        }
    }

    //add vehicle on database
    public void addVehicleOnAction(ActionEvent actionEvent) {

        String vehicleId = txtVehicleNo.getText();
        String vehicleName = txtVehicleName.getText();
        String brand = txtBrand.getText();
        String dayCharge = txtDayOfCharge.getText();
        String fuelType = cmbFuelType.getValue();
        String vehicleType = txtVehicleType.getText();
        String status = cmbstatus.getValue();

        if(vehicleId.equalsIgnoreCase("")||vehicleName.equalsIgnoreCase("") ||
                brand.equalsIgnoreCase("")||dayCharge.equalsIgnoreCase("")||fuelType == null||
                vehicleType.equalsIgnoreCase("") || imageName == null||status==null){

            new Alert(Alert.AlertType.ERROR,"Please Fill the Blanks").show();
        }else{
            Vehicle vehicle = new Vehicle(vehicleId,vehicleName,brand,Double.parseDouble(dayCharge),fuelType,vehicleType,imageName,status);

            try {

                boolean isAdded = VehicleModel.addVehicle(vehicle);

                if (isAdded){
                    new Alert(Alert.AlertType.INFORMATION,"Added Success").show();
                    setTableData();
                    clearTextField();
                }else {
                    new Alert(Alert.AlertType.INFORMATION,"Added Failed").show();
                }


            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    //load the all data on ui table
    public void setTableData(){
        ObservableList<VehicleTM> vehicleList = FXCollections.observableArrayList();

        try {
            ArrayList<Vehicle> allVehicle = VehicleModel.getAllVehicle();

            for (Vehicle v : allVehicle) {
                VehicleTM vehicleTM = new VehicleTM(v.getVehicleNo(),v.getName(),v.getBrand(),
                        v.getDayOfCharge(),v.getFuelType(),
                        v.getVehicleType(),v.getImage(),v.getStatus());

                vehicleList.add(vehicleTM);
            }
            vehicleTable.setItems(vehicleList);
            vehicleTable.refresh();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  void setValueFactory(){
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("VehicleNo"));
        colName.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("name"));
        colBrand.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("brand"));
        colDayCharge.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("dayOfCharge"));
        colfuelType.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("fuelType"));
        colVType.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("vehicleType"));
        colimage.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("image"));
        colStatus.setCellValueFactory(new PropertyValueFactory<VehicleTM,String>("status"));
    }

    public void AddListener(){
        vehicleTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null) {
                setVehicleDataToTextField(newValue);
            }
        });
    }
    //settable data text field
    private void setVehicleDataToTextField(VehicleTM v) {
       txtVehicleNo.setText(v.getVehicleNo());
       txtVehicleName.setText(v.getName());
       txtBrand.setText(v.getBrand());
       txtDayOfCharge.setText(String.valueOf(v.getDayOfCharge()));
       cmbFuelType.setValue(v.getFuelType());
       txtVehicleType.setText(v.getVehicleType());
       setPic(v.getImage());
       cmbstatus.setValue(v.getStatus());

    }

    //Delete vehicle on database
    public void deleteVehicleOnAction(ActionEvent actionEvent) {
        String vehicleId = txtVehicleNo.getText();
        String vehicleName = txtVehicleName.getText();
        String brand = txtBrand.getText();
        String dayCharge = txtDayOfCharge.getText();
        String fuelType = cmbFuelType.getValue();
        String vehicleType = txtVehicleType.getText();
        String status = cmbstatus.getValue();

        if(vehicleId.equalsIgnoreCase("")||vehicleName.equalsIgnoreCase("") ||
                brand.equalsIgnoreCase("")||dayCharge.equalsIgnoreCase("")||fuelType == null||
                vehicleType.equalsIgnoreCase("") || imageName == null||status==null){

            new Alert(Alert.AlertType.ERROR,"Please Fill the Blanks").show();


        }else{
            try {
                boolean deleted = VehicleModel.deleteVehicle(vehicleId);
                if (deleted){
                    new Alert(Alert.AlertType.INFORMATION,"Delete Success").show();
                    clearTextField();
                    setTableData();

                }else{
                    new Alert(Alert.AlertType.INFORMATION,"Delete Failed").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    //update vehicle on database
    public void updateVehicleOnAction(ActionEvent actionEvent) {
        String vehicleId = txtVehicleNo.getText();
        String vehicleName = txtVehicleName.getText();
        String brand = txtBrand.getText();
        String dayCharge = txtDayOfCharge.getText();
        String fuelType = cmbFuelType.getValue();
        String vehicleType = txtVehicleType.getText();
        String status = cmbstatus.getValue();


        if(vehicleId.equalsIgnoreCase("")||vehicleName.equalsIgnoreCase("") ||
                brand.equalsIgnoreCase("")||dayCharge.equalsIgnoreCase("")||fuelType == null||
                vehicleType.equalsIgnoreCase("") || imageName == null||status==null){

            new Alert(Alert.AlertType.ERROR,"Please Fill the Blanks").show();
            imgvehicle.setImage(null);

        }else{
            Vehicle vehicle  = new Vehicle(vehicleId,vehicleName,brand,Double.parseDouble(dayCharge),fuelType,vehicleType,imageName,status);
            try {
                boolean updated = VehicleModel.updateVehicle(vehicle);
                if (updated){
                    new Alert(Alert.AlertType.INFORMATION,"Update Success").showAndWait();
                    setTableData();
                    clearTextField();
                }else{
                    new Alert(Alert.AlertType.INFORMATION,"Update Failed").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
    //clear text fields
    private void clearTextField(){
        txtVehicleNo.clear();
        txtVehicleName.clear();
        txtBrand.clear();
        txtDayOfCharge.clear();
        txtVehicleType.clear();
        cmbstatus.setValue(null);
        cmbFuelType.setValue(null);
        imgvehicle.setImage(null);


    }
    //set image on Imageview
    private void setPic(String photo) {
        try {
            File file = new File(photo);
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgvehicle.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
