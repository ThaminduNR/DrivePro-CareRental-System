package com.drivepro.controller;

import com.drivepro.db.DBConnection;
import com.drivepro.util.Navigation;
import com.drivepro.util.Routes;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Stage stage = (Stage) dashboradPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainStageForm.fxml"))));
        stage.centerOnScreen();
    }

    public void loadCustomerFormONAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.CUSTOMER,MainContext);
    }

    public void loadVehicleFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.VEHICLE,MainContext);

    }

    public void loadEmployeeFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.EMPLOYEE,MainContext);
    }

    public void loadBookingVehicleFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.BOOKING,MainContext);
    }

    public void loadIncomeReportOnActopn(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.INCOME,MainContext);
    }

    public void loadReturnFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.RETURN,MainContext);
    }

    public void loadHomeFonrmOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.HOME,MainContext);
    }

    public void loadReservedFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigatePane(Routes.RESERVED,MainContext);
    }
    private void loadCountOfVehicle() {
        String count = "";
        try {
            String sql = "SELECT COUNT(vehicleNo) FROM vehicle";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblAllVehicle.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfCustomers() {
        String count = "";
        try {
            String sql = "SELECT COUNT(customerId) FROM customer";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblAllCustomers.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfBooking() {
        String count = "";
        try {
            String sql = "SELECT COUNT(bookingId) FROM booking";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblBooking.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfReturn() {
        String count = "";
        try {
            String sql = "SELECT COUNT(vehicleNo) FROM returnvehicle";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblReturn.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCountOfReserveVehicle() {
        String count = "";
        try {
            String sql = "SELECT COUNT(vehicleNo) FROM vehicleDetail";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getString(1);
            }

            lblReseve.setText(count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
