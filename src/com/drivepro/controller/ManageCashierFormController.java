package com.drivepro.controller;

import com.drivepro.model.CashierModel;
import com.drivepro.to.Cashier;
import com.drivepro.view.tm.CashierTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCashierFormController {
    public TextField txtCashId;
    public TextField txtCashName;
    public TextField txtAge;
    public TextField txtCashContact;
    public TextField txtCashAddress;
    public TextField txtPws;

    public TableView<CashierTM> cashierTable;

    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colAge;
    public TableColumn colPws;



    public void initialize(){
        setTableData();
        setValueFactory();
        AddListener();
    }

    public void addCashierOnAction(ActionEvent actionEvent) {
        String id = txtCashId.getText();
        String name  = txtCashName.getText();
        String address = txtCashAddress.getText();
        String contact = txtCashContact.getText();
        String password = txtPws.getText();



        if (id.equalsIgnoreCase("")||name.equalsIgnoreCase("")||address.equalsIgnoreCase("")||contact.equalsIgnoreCase("")||
            txtAge.getText().equalsIgnoreCase("")||password.equalsIgnoreCase("")){

            new Alert(Alert.AlertType.ERROR,"Please fill the Blanks").show();
        }else {
            try {
                int age = Integer.parseInt(txtAge.getText());
                Cashier cashier = new Cashier(id,name,address,contact,age,password);
                boolean isAdded = CashierModel.addCashier(cashier);
                if (isAdded){
                    new Alert(Alert.AlertType.INFORMATION,"Added Success");
                    setTableData();
                    clearText();
                }else{
                    new Alert(Alert.AlertType.INFORMATION,"Added Failed");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateCashierOnAction(ActionEvent actionEvent) {
        String id = txtCashId.getText();
        String name  = txtCashName.getText();
        String address = txtCashAddress.getText();
        String contact = txtCashContact.getText();

        String password = txtPws.getText();

        if(id.equalsIgnoreCase("")||name.equalsIgnoreCase("")||address.equalsIgnoreCase("")||contact.equalsIgnoreCase("")||
                txtAge.getText().equalsIgnoreCase("")||password.equalsIgnoreCase("")){

            new Alert(Alert.AlertType.ERROR,"Fill the blanks ").show();

        }else {
            int age = Integer.parseInt(txtAge.getText());
            Cashier cashier = new Cashier(id,name,address,contact,age,password);
            try {
                boolean updated = CashierModel.updateCustomer(cashier);
                if (updated){
                    new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
                    setTableData();
                    clearText();
                }else{
                    new Alert(Alert.AlertType.ERROR,"Update Failed").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteCashierOnAction(ActionEvent actionEvent) {
        String id = txtCashId.getText();
        String name  = txtCashName.getText();
        String address = txtCashAddress.getText();
        String contact = txtCashContact.getText();
        String password = txtPws.getText();

        if (id.equalsIgnoreCase("")||name.equalsIgnoreCase("")||address.equalsIgnoreCase("")||contact.equalsIgnoreCase("")||
                txtAge.getText().equalsIgnoreCase("")||password.equalsIgnoreCase("")){

            new Alert(Alert.AlertType.ERROR,"Choose the Cashier").show();

        }else {
            try {
                boolean isDeleted = CashierModel.deleteCashier(id);
                if (isDeleted){
                    new Alert(Alert.AlertType.INFORMATION,"Delete Success").show();
                    setTableData();
                    clearText();
                }else{
                    new Alert(Alert.AlertType.ERROR,"Delete Failed").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void setTableData(){
        ObservableList<CashierTM> cashierList = FXCollections.observableArrayList();
        try {
            ArrayList<Cashier> allCashier = CashierModel.getAllCashier();
            for (Cashier c :allCashier) {
                CashierTM cashierTM = new CashierTM(c.getCashierId(), c.getName(), c.getAddress(), c.getContact(), c.getAge(), c.getPassword());
                cashierList.add(cashierTM);
            }
            cashierTable.setItems(cashierList);
            cashierTable.refresh();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public  void setValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<CashierTM,String>("cashierId"));
        colName.setCellValueFactory(new PropertyValueFactory<CashierTM,String>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<CashierTM,String>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<CashierTM,String>("contact"));
        colAge.setCellValueFactory(new PropertyValueFactory<CashierTM,String>("age"));
        colPws.setCellValueFactory(new PropertyValueFactory<CashierTM,String>("password"));
    }

    public void AddListener(){
        cashierTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null) {
                setDataToTextField(newValue);
            }
        });
    }

    private void setDataToTextField(CashierTM c) {
        txtCashId.setText(c.getCashierId());
        txtCashName.setText(c.getName());
        txtCashAddress.setText(c.getAddress());
        txtCashContact.setText(c.getContact());
        txtAge.setText(String.valueOf(c.getAge()));
        txtPws.setText(c.getPassword());
    }

    public void clearText(){
        txtCashId.clear();
        txtCashName.clear();
        txtCashAddress.clear();
        txtCashContact.clear();
        txtAge.clear();
        txtPws.clear();
    }
}
