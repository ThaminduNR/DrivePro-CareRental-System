package com.drivepro.controller;

import com.drivepro.bo.BOFactory;
import com.drivepro.bo.BOTypes;
import com.drivepro.bo.custom.CustomerBO;
import com.drivepro.bo.custom.impl.CustomerBOImpl;
import com.drivepro.dto.CustomerDTO;
import com.drivepro.util.Navigation;
import com.drivepro.util.Routes;
import com.drivepro.util.Validator;
import com.drivepro.view.tm.CustomerTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ManageCustomerFormController {

    public TextField txtcustId;
    public TextField txtcustName;
    public TextField txtAge;
    public TextField txtContact;
    public TextField txtDob;
    public TextField txtAddress;

    public TableView<CustomerTM> customerTable;

    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colAge;
    public TableColumn colDob;
    public AnchorPane customerContext;

     CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOTypes.CUSTOMER);


    public void initialize() {

        setValueFactory();
        setTableData();
        AddListener();
        generateOrderId();
    }


    private void generateOrderId() {
        try {
            String lastOrderId = customerBO.getLastOrderId();
            if (lastOrderId != null) {
                lastOrderId = lastOrderId.split("[A-Z]")[1];
                System.out.println(lastOrderId);
                lastOrderId = String.format("C%03d", (Integer.parseInt(lastOrderId) + 1));
                txtcustId.setText(lastOrderId);
            } else {
                txtcustId.setText("C001");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void addCustomerOnAction(ActionEvent actionEvent) throws IOException {

        String id = txtcustId.getText();
        String name = txtcustName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String age = txtAge.getText();
        String dob = txtDob.getText();


        if (id.equalsIgnoreCase("") || name.equalsIgnoreCase("") || address.equalsIgnoreCase("") || contact.equalsIgnoreCase("") || age.equalsIgnoreCase("") || dob.equalsIgnoreCase("")) {

            new Alert(Alert.AlertType.ERROR, "Empty TextField Please fill the blanks").show();

        } else {
            if (Validator.isPhoneNumberMatch(txtContact.getText())) {
                int agenew = Integer.parseInt(txtAge.getText());
                try {

                    CustomerDTO customerDTO = new CustomerDTO(id, name, address, contact, agenew, dob);
                    boolean isAdded = customerBO.addCustomer(customerDTO);

                    if (isAdded) {
                        new Alert(Alert.AlertType.INFORMATION, "Added Success").show();
                        clearText();
                        setTableData();
                    } else {
                        new Alert(Alert.AlertType.INFORMATION, "Added failed").show();
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Navigation.navigatePane(Routes.CUSTOMER, customerContext);

            } else {
                new Alert(Alert.AlertType.ERROR, "Wrong phone number!").show();
            }
        }

    }

    public void updateCustomerOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtcustId.getText();
        String name = txtcustName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String age = txtAge.getText();
        String dob = txtDob.getText();

        if (id.equalsIgnoreCase("") || name.equalsIgnoreCase("") || address.equalsIgnoreCase("") || contact.equalsIgnoreCase("") || age.equalsIgnoreCase("") || dob.equalsIgnoreCase("")) {

            new Alert(Alert.AlertType.ERROR, "Empty TextField Please fill the blanks").show();

        } else {

            try {
                int agenew = Integer.parseInt(txtAge.getText());


                CustomerDTO customerDTO = new CustomerDTO(id, name, address, contact, agenew, dob);
                boolean isUpdate = false;

                isUpdate = customerBO.updateCustomer(customerDTO);
                if (isUpdate) {
                    new Alert(Alert.AlertType.INFORMATION, "Update Success").show();
                    clearText();
                    setTableData();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Update Failed").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            Navigation.navigatePane(Routes.CUSTOMER, customerContext);

        }

    }

    public void deleteCustomerOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtcustId.getText();
        String name = txtcustName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String age = txtAge.getText();
        String dob = txtDob.getText();

        if (id.equalsIgnoreCase("") || name.equalsIgnoreCase("") || address.equalsIgnoreCase("") || contact.equalsIgnoreCase("") || age.equalsIgnoreCase("") || dob.equalsIgnoreCase("")) {

            new Alert(Alert.AlertType.ERROR, "Empty TextField Please fill the blanks").show();

        } else {
            try {
                boolean deleted = customerBO.deleteCustomer(id);
                if (deleted) {
                    new Alert(Alert.AlertType.INFORMATION, "Delete Success").show();
                    clearText();
                    setTableData();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Delete failed").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            Navigation.navigatePane(Routes.CUSTOMER, customerContext);
        }
    }

    public void setValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("contact"));
        colAge.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("age"));
        colDob.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("dob"));
    }

    public void setTableData() {
        ObservableList<CustomerTM> cust = FXCollections.observableArrayList();
        try {
            ArrayList<CustomerDTO> allCustomer = customerBO.getAllCustomer();
            for (CustomerDTO c : allCustomer) {
                CustomerTM customerTM = new CustomerTM(c.getCustomerId(), c.getName(), c.getAddress(), c.getContact(), c.getAge(), c.getDob());
                cust.add(customerTM);

            }
            customerTable.setItems(cust);
            customerTable.refresh();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void AddListener() {
        customerTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setDataToTextField(newValue);
            }
        });
    }

    private void setDataToTextField(CustomerTM c) {
        txtcustId.setText(c.getCustomerId());
        txtcustName.setText(c.getName());
        txtAddress.setText(c.getAddress());
        txtContact.setText(c.getContact());
        txtAge.setText(String.valueOf(c.getAge()));
        txtDob.setText(c.getDob());
    }

    public void clearText() {
        txtcustId.clear();
        txtcustName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtAge.clear();
        txtDob.clear();
    }

    public void generateAgeOnAction(ActionEvent actionEvent) {
        String date = txtDob.getText();
        LocalDate dob = LocalDate.parse(date);
        int i = calculateAge(dob);
        txtAge.setText(String.valueOf(i));
    }

    public static int calculateAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }
}

