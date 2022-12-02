package com.drivepro.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierLoginFormController {
    public AnchorPane cashierLoginpane;
    public TextField txtemailid;
    public PasswordField pwstxt;

    public void cashierCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cashierLoginpane.getScene().getWindow();
        stage.close();
    }

    public void cashierLoginOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtemailid.getText();
        String pws = pwstxt.getText();
        if (email.equals("") && pws.equals("")){

            Stage stage = (Stage) cashierLoginpane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainDashboardCashier.fxml"))));
            stage.centerOnScreen();
        }else{
            wrongUsername();

        }

    }

    private void wrongUsername() {
    }
}
