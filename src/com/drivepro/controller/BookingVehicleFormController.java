package com.drivepro.controller;

import com.drivepro.bo.BOFactory;
import com.drivepro.bo.BOTypes;
import com.drivepro.bo.custom.BookingOrderBO;
import com.drivepro.bo.custom.impl.BookingOrderBOImpl;
import com.drivepro.model.BookingModel;
import com.drivepro.util.Navigation;
import com.drivepro.util.Routes;
import com.drivepro.view.tm.CartTM;
import com.jfoenix.controls.JFXDatePicker;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class BookingVehicleFormController {

    public TextField txtbookingId;

    public ComboBox<String> cmbCustId;
    public TextField txtcustName;
    public TextField txtCustAddress;
    public TextField txtCustContact;
    public TextField txtCustAge;
    public TextField txtCustDOB;

    public ComboBox<String> cmbVId;
    public TextField txtVname;
    public TextField txtVbrand;
    public TextField txtVdoc;
    public TextField txtFuelType;
    public TextField txtVtype;
    public ImageView imgVehicle;
    public Label txtStatus;

    public JFXDatePicker txtSdate;
    public JFXDatePicker txtEdate;
    public TextField txtDayCount;
    public TextField txtqty;
    public Label lblDate;
    public Label lblTime;


    public TableColumn<CartTM, String> colVnumber;
    public TableColumn<CartTM, String> colVname;
    public TableColumn<CartTM, String> colSdate;
    public TableColumn<CartTM, String> colEdate;
    public TableColumn<CartTM, String> coldayCount;
    public TableColumn<CartTM, String> colDaycharge;
    public TableColumn<CartTM, String> colTotal;
    public TableColumn<CartTM, String> colOption;

    public Label tblTotal;
    public TableView<CartTM> tblCart;
    public AnchorPane bookinContext;
    public ObservableList<CartTM> cartList = FXCollections.observableArrayList();

    BookingOrderBO bookingOrderBO = (BookingOrderBO) BOFactory.getBoFactory().getBO(BOTypes.BOOKINGORDER);

    public void initialize() {

        initClock();
        initDate();
        loadCustomerId();
        loadVehicleNumber();
        changeListenerCrust();
        changeListenerVehicle();
        setValueFactory();
        /*setOrderId();*/
        generateOrderId();
    }

    private void generateOrderId() {
        try {
            String lastOrderId = bookingOrderBO.getLastOrderId();
            if (lastOrderId != null) {
                lastOrderId = lastOrderId.split("[A-Z]")[1];
                System.out.println(lastOrderId);
                lastOrderId = String.format("B%03d", (Integer.parseInt(lastOrderId) + 1));
                txtbookingId.setText(lastOrderId);
            } else {
                txtbookingId.setText("B001");
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /*private void setOrderId() {
        try{
            String sql = "SELECT bookingId FROM `booking` ORDER BY bookingId DESC LIMIT 1"; // 10 not working... (UNSIGNED)
            ResultSet set = CrudUtil.execute(sql);
            *//*PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);*//*
            if (set.next()){
                String tempOrderId=set.getString(1);
                String[] array = tempOrderId.split("-");//[D,3]
                int tempNumber=Integer.parseInt(array[1]);
                int finalizeOrderId=tempNumber+1;
                txtbookingId.setText("B-"+finalizeOrderId);
            }else {
                txtbookingId.setText("B-1");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }*/

    private void initDate() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            lblDate.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void changeListenerCrust() {

        cmbCustId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                changeStateCustID(1);
            }
        });
    }

    private void changeListenerVehicle() {
        cmbVId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                ChangeStateVehicleNo(1);
                String id = cmbVId.getValue();
            }

        });

    }

    private void loadCustomerId() {
        try {
            ObservableList<String> cusIdList = bookingOrderBO.loadCustomerId();
            cmbCustId.setItems(cusIdList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeStateCustID(int actionEvent) {
        String cust = cmbCustId.getValue().toString();
        try {
            ResultSet res = bookingOrderBO.changeStateCustID(cust);
            if (res.next()) {
                txtcustName.setText(res.getString("name"));
                txtCustAddress.setText(res.getString("address"));
                txtCustContact.setText(res.getString("contact"));
                txtCustAge.setText(res.getString("age"));
                txtCustDOB.setText(res.getString("dob"));

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ChangeStateVehicleNo(int actionEvent) {
        String num = cmbVId.getValue().toString();

        try {

            ResultSet res = bookingOrderBO.ChangeStateVehicleNo(num);
            if (res.next()) {
                txtVname.setText(res.getString(2));
                txtVbrand.setText(res.getString(3));
                txtVdoc.setText(res.getString(4));
                txtFuelType.setText(res.getString(5));
                txtVtype.setText(res.getString(6));
                setPic(res.getString(7));
                txtStatus.setText(res.getString(8));


            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setPic(String vehiclePhoto) {
        try {
            File file = new File(vehiclePhoto);
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgVehicle.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadVehicleNumber() {
        try {
            ObservableList<String> vehicleNoList = bookingOrderBO.loadVehicleNumber();
            cmbVId.setItems(vehicleNoList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dateCountOnAction(ActionEvent actionEvent) {
        String firstDate = txtSdate.getValue().toString();
        String secDate = txtEdate.getValue().toString();

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateBefore = myFormat.parse(firstDate);
            Date dateAfter = myFormat.parse(secDate);
            long difference = dateAfter.getTime() - dateBefore.getTime();
            float daysBetween = (difference / (1000 * 60 * 60 * 24));
            int value = (int) daysBetween;
            if (value > 0) {
                txtDayCount.setText(String.valueOf(value));
                System.out.println("Number of Days between dates: " + value);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Date");
                alert.setTitle("Invalid Date");
                alert.show();

                System.out.println("Invalid Date");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Add to Cart method
    public void addToCartOnAction(ActionEvent actionEvent) {

        String state = txtStatus.getText();
        String daycharge = txtVdoc.getText();
        String dcount = txtDayCount.getText();

        if (cmbCustId.getValue() == null || txtcustName.getText().equalsIgnoreCase("") || txtCustAddress.getText().equalsIgnoreCase("") ||
                txtCustContact.getText().equalsIgnoreCase("") || txtCustAge.getText().equalsIgnoreCase("") || txtCustDOB.getText().equalsIgnoreCase("") ||
                cmbVId.getValue() == null || txtVname.getText().equalsIgnoreCase("") || txtVbrand.getText().equalsIgnoreCase("") || txtVdoc.getText().equalsIgnoreCase("") ||
                txtFuelType.getText().equalsIgnoreCase("") || txtVtype.getText().equalsIgnoreCase("") || imgVehicle == null || txtSdate == null || txtEdate == null ||
                txtStatus.getText().equalsIgnoreCase("") || txtDayCount.getText().equalsIgnoreCase("")) {

            new Alert(Alert.AlertType.ERROR, "Please fill the blanks").show();

        } else {

            if (cartList.size() == 1 || state.equalsIgnoreCase("Unavailable")) {
                new Alert(Alert.AlertType.ERROR, "Sorry! This Vehicle UnAvailable or wrong date ").show();

            } else {
                double dayOfCharge = Double.parseDouble(txtVdoc.getText());
                int dayCount = Integer.parseInt(txtDayCount.getText());
                double total = dayCount * dayOfCharge;

                Button btn = new Button("Remove");
                CartTM cartTM = new CartTM(cmbVId.getValue(), txtVname.getText(), txtSdate.getValue().toString(),
                        txtEdate.getValue().toString(), dayCount, dayOfCharge, total, btn);

                cartList.add(cartTM);
                tblCart.setItems(cartList);
                calculateTotal();

                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Are You sure", ButtonType.YES, ButtonType.CANCEL);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        for (CartTM tm : cartList) {
                            cartList.remove(tm);
                            calculateTotal();
                            tblCart.refresh();
                            return;


                        }
                    }
                });
            }

        }


        // System.out.println("total is: "+total);
    }

    public void setValueFactory() {
        colVnumber.setCellValueFactory(new PropertyValueFactory<CartTM, String>("id"));
        colVname.setCellValueFactory(new PropertyValueFactory<CartTM, String>("name"));
        colSdate.setCellValueFactory(new PropertyValueFactory<CartTM, String>("Sdate"));
        colEdate.setCellValueFactory(new PropertyValueFactory<CartTM, String>("Edate"));
        coldayCount.setCellValueFactory(new PropertyValueFactory<CartTM, String>("dayCount"));
        colDaycharge.setCellValueFactory(new PropertyValueFactory<CartTM, String>("dayOfCharge"));
        colTotal.setCellValueFactory(new PropertyValueFactory<CartTM, String>("total"));
        colOption.setCellValueFactory(new PropertyValueFactory<CartTM, String>("btn"));

    }

    private void clearAll() {

        txtcustName.clear();
        txtCustAddress.clear();
        txtCustContact.clear();
        txtCustAge.clear();
        txtCustDOB.clear();

        txtDayCount.clear();
        txtSdate.setValue(null);
        txtEdate.setValue(null);
        txtVname.clear();
        txtVbrand.clear();
        txtVdoc.clear();
        txtFuelType.clear();
        txtVtype.clear();
        imgVehicle.setImage(null);
        txtStatus.setText("");
    }

    private void calculateTotal() {
        double total = 0.00;
        for (CartTM tm : cartList) {
            total += tm.getTotal();
        }
        tblTotal.setText(String.valueOf(total));
    }

    //bookingOrders
    public void bookingOrderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {

        if (!cartList.isEmpty()) {
            String bookingId = txtbookingId.getText();
            String date = lblDate.getText();
            double totalCost = Double.parseDouble(tblTotal.getText());
            String custId = cmbCustId.getValue();
            String num = cmbVId.getValue();
            String name = txtVname.getText();
            String sDate = txtSdate.getValue().toString();
            String eDate = txtEdate.getValue().toString();
            int dayCount = Integer.parseInt(txtDayCount.getText());
            double dayCharge = Double.parseDouble(txtVdoc.getText());


            //send data to BookingDetails table
            boolean isAdded = bookingOrderBO.bookingOrder(bookingId, date, totalCost, custId, num, name, sDate, eDate, dayCount, dayCharge);
            if (isAdded) {
                System.out.println("Booking detail Added");
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Booking Is Completed");
                alert.setTitle("Complete");
                alert.show();
                sendDataPaymentStage();
                changeVehicleState(num);
                clearAll();
                //refresh the page
                Navigation.navigatePane(Routes.BOOKING, bookinContext);
                for (CartTM tm : cartList) {
                    cartList.remove(tm);
                    return;
                }
            }

        } else {

            new Alert(Alert.AlertType.ERROR, "Cart Is empty").show();
        }
    }

    public void changeVehicleState(String id) {
        boolean isUpdate = false;
        try {
            isUpdate = bookingOrderBO.changeVehicleState(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (isUpdate) {
            System.out.println("State Change");
        }

    }

    public void sendDataPaymentStage() throws IOException {
        String custId = cmbCustId.getValue();
        String date = lblDate.getText();
        String time = lblTime.getText();
        String vnumber = cmbVId.getValue();
        String totsl = tblTotal.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PaymentForm.fxml"));
        Parent root = loader.load();

        PaymentFormController pc = loader.getController();
        pc.detDataToTextField(custId, date, time, vnumber, totsl);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void paymentNowOnAction() {
        //Do not remove this method
    }

    public void addNewCustomer(ActionEvent actionEvent) {
        try {
            Navigation.navigatePane(Routes.CUSTOMER, bookinContext);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
