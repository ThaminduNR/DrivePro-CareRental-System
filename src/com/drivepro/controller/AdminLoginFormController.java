package com.drivepro.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


public class AdminLoginFormController {
    public AnchorPane adminLoginpane;
    public TextField txtemailid;
    public PasswordField pwstxt;

    public void admincloseOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) adminLoginpane.getScene().getWindow();
        stage.close();



    }

    public void logintrueOnAction(ActionEvent actionEvent) throws IOException {
        String user = txtemailid.getText();
        String pws = pwstxt.getText();

        /*try {
            if (user != null && pws != null) {
                String sql = "Select * from admin Where adminId ='" + user + "' and password='" + pws + "'";
                ResultSet rs = CrudUtil.execute(sql);
                if (rs.next()) {
                    Stage stage = (Stage) adminLoginpane.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainDashboard.fxml"))));
                    stage.centerOnScreen();
                } else {
                    wrongUsername();
                }
            }

            // You can also validate user by result size if its comes zero user is invalid else user is valid

        } catch (SQLException | ClassNotFoundException err) {
            err.printStackTrace();
        }*/

        if (user.equals("") && pws.equals("")){

            Stage stage = (Stage) adminLoginpane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainDashboard.fxml"))));
            stage.centerOnScreen();
            stage.setOpacity(0.98);
        }else{
            wrongUsername();

        }
    }

    private void wrongUsername(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Wrong Username or Password");
        alert.showAndWait();
    }
}
