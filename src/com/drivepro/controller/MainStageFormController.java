package com.drivepro.controller;

import com.drivepro.AppInitializer;
import com.drivepro.util.Navigation;
import com.drivepro.util.Routes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainStageFormController {
    public MediaView mediaview;
    public AnchorPane mainPane;
    public  AnchorPane btnpallet;
    public AnchorPane loginContext;



    public void initialize() {
        Media media = new Media("file:///C:/Users/thami/OneDrive/Desktop/Tupi/video.mp4");
        MediaPlayer player = new MediaPlayer(media);
        mediaview.setMediaPlayer(player);
        player.setVolume(0);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();



    }

    public void closeBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        System.exit(0);

    }

    public void adminloginonAction(ActionEvent actionEvent) throws IOException {

        Navigation.userNavigate(Routes.ADMIN);
      /*  btnpallet.setVisible(false);*/


    }

    public void cashierLoginOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.userNavigate(Routes.CASHIER);

    }

    public void setButtonPallet(boolean b){
        btnpallet.setVisible(b);
    }


}
