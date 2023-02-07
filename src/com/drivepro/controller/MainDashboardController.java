package com.drivepro.controller;

import com.drivepro.bo.BOFactory;
import com.drivepro.bo.BOTypes;
import com.drivepro.bo.custom.MainDBoardBO;
import com.drivepro.bo.custom.impl.MainDBoardBOImpl;
import com.drivepro.util.Navigation;
import com.drivepro.util.Routes;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainDashboardController implements Initializable {


    public AnchorPane sidePane;
    public Button navbtn;
    public Button clsbtn;
    public AnchorPane dashboradPane;
    public AnchorPane MainContext;
    public Label lblAllCustomers;
    public Label lblAllVehicle;
    public Label lblBooking;
    public Label lblReturn;
    public Label lblReseve;

    MainDBoardBO mainDBoardBO = (MainDBoardBO) BOFactory.getBoFactory().getBO(BOTypes.MAINDBOARD);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sidePane.setTranslateX(-330);
        clsbtn.setVisible(false);
        loadCountOfVehicle();
        loadCountOfCustomers();
        loadCountOfBooking();
        loadCountOfReturn();
        loadCountOfReserveVehicle();

    }

    public void navbtnOnAction(MouseEvent mouseEvent) {
        TranslateTransition side = new TranslateTransition();
        side.setDuration(Duration.seconds(0.8));
        side.setNode(sidePane);
        side.setToX(0);
        side.play();

        sidePane.setTranslateX(-330);
        side.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                clsbtn.setVisible(true);
                navbtn.setVisible(false);

            }
        });

    }

    public void closebtnOnAction(MouseEvent mouseEvent) {
        TranslateTransition side = new TranslateTransition();
        side.setDuration(Duration.seconds(0.8));
        side.setNode(sidePane);
        side.setToX(-330);
        side.play();

        sidePane.setTranslateX(0);
        side.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                navbtn.setVisible(true);
                clsbtn.setVisible(false);

            }
        });

    }

    public void dashboardcloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) dashboradPane.getScene().getWindow();
        stage.close();


    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setContentText("Are you sure want to log out?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) dashboradPane.getScene().getWindow();
            stage.close();
        } else {
            System.out.println("Try Again");
        }

    }

    public void loadCustomerFormONAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.CUSTOMER, MainContext);
    }

    public void loadVehicleFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.VEHICLE, MainContext);

    }

    public void loadEmployeeFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.EMPLOYEE, MainContext);
    }

    public void loadBookingVehicleFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.BOOKING, MainContext);
    }

    public void loadIncomeReportOnActopn(ActionEvent actionEvent) throws IOException {
//        Navigation.navigatePane(Routes.INCOME,MainContext);
    }

    public void loadReturnFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.RETURN, MainContext);
    }

    public void loadHomeFonrmOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.HOME, MainContext);
    }

    public void loadReservedFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.RESERVED, MainContext);
    }

    //data view ports
    private void loadCountOfVehicle() {
        try {
            String count = mainDBoardBO.loadCountOfVehicle();
            lblAllVehicle.setText(count);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfCustomers() {

        try {
            String count = mainDBoardBO.loadCountOfCustomers();
            lblAllCustomers.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfBooking() {

        try {
            String count = mainDBoardBO.loadCountOfBooking();
            lblBooking.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfReturn() {

        try {
            String count = mainDBoardBO.loadCountOfReturn();
            lblReturn.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfReserveVehicle() {

        try {
            String count = mainDBoardBO.loadCountOfReserveVehicle();
            lblReseve.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
