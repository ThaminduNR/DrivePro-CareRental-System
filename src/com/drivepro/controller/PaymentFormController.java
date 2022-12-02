package com.drivepro.controller;

import com.drivepro.model.PaymentModel;
import com.drivepro.to.Payment;
import com.drivepro.util.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentFormController {
    public AnchorPane paymentpane;
    public TextField txtpaymentId;
    public TextField txtCustId;
    public TextField txtPayDate;
    public TextField txtPayTime;
    public TextField tottalPayment;
    public ComboBox<String> cmbmethod;
    public TextField txtVnumber;

    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList("Cash","Card","Cheque");
        cmbmethod.setItems(obList);

        setPaymentId();
    }

    private void setPaymentId() {
        try{
            String sql = "SELECT paymentId FROM `payment` ORDER BY paymentId DESC LIMIT 1"; // 10 not working... (UNSIGNED)
            ResultSet set = CrudUtil.execute(sql);
            /*PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);*/
            if (set.next()){
                String tempOrderId=set.getString(1);
                String[] array = tempOrderId.split("-");//[D,3]
                int tempNumber=Integer.parseInt(array[1]);
                int finalizeOrderId=tempNumber+1;
                txtpaymentId.setText("P0-"+finalizeOrderId);
            }else {
                txtpaymentId.setText("P0-1");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public void paymentOnAction(ActionEvent actionEvent) {
        String paymentId = txtpaymentId.getText();
        String custId = txtCustId.getText();
        String paydate = txtPayDate.getText();
        String payTime = txtPayTime.getText();
        String vehicleNo = txtVnumber.getText();
        String method = cmbmethod.getValue();
        String totPay =tottalPayment.getText();

        if (method==null||paymentId==null||custId==null||paydate==null||payTime==null||vehicleNo==null||totPay==null){
            new Alert(Alert.AlertType.ERROR,"Please Select Payment Method ").show();

        }else {
            double totalPay = Double.parseDouble(tottalPayment.getText());
            Payment payment = new Payment(paymentId,custId,paydate,payTime,vehicleNo,totalPay,method);
            try {
                boolean isAdded = PaymentModel.sendDataPaymentTable(payment);
                if (isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION,"Payment Successful").show();
                    cancelOnAction(actionEvent);
                }else {
                    new Alert(Alert.AlertType.ERROR,"Payment Error").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void cancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) paymentpane.getScene().getWindow();
        stage.close();
    }

    public void detDataToTextField(String custId, String date, String time, String vnumber, String totsl) {

        txtCustId.setText(custId);
        txtPayDate.setText(date);
        txtPayTime.setText(time);
        txtVnumber.setText(vnumber);
        tottalPayment.setText(totsl);
    }
}
