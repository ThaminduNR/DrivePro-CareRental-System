package com.drivepro.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Navigation {
    public static void userNavigate(Routes routes) throws IOException {

        switch (routes){
            case ADMIN:
               setUI("AdminLoginForm.fxml");
               break;

            case CASHIER:
                setUI("CashierLoginForm.fxml");
                break;

        }

    }

    private static void setUI(String location) throws IOException {
        Stage stage = new Stage();
       /* stage.initStyle(StageStyle.UNDECORATED);*/
        stage.setScene(new Scene(FXMLLoader.load(Navigation.class.getResource("../view/"+location))));
        stage.show();
        stage.centerOnScreen();
//
    }

    public static void navigatePane(Routes route, AnchorPane pane) throws IOException {
        switch (route) {
            case CUSTOMER:
                initUI("ManageCustomerForm.fxml", pane);
                break;

            case VEHICLE:

                initUI("ManageVehicleForm.fxml", pane);
                break;

            case EMPLOYEE:

                initUI("ManageCashierForm.fxml", pane);
                break;
            case BOOKING:

                initUI("BookingVehicleForm.fxml", pane);
                break;
            case INCOME:

                initUI("IncomeReportsForm.fxml", pane);
                break;

            case RETURN:

                initUI("ManageReturnForm.fxml", pane);
                break;

            case HOME:

                initUI("HomeForm.fxml", pane);
                break;

            case CHOME:

                initUI("HomeCashierForm.fxml", pane);
                break;

            case RESERVED:

                initUI("ManageVehicleDetailsForm.fxml", pane);
                break;

        }
    }

    private static void initUI(String location, AnchorPane pane) throws IOException,NullPointerException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/com/drivepro/view/" + location)));

    }
}
