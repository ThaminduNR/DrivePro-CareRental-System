package com.drivepro.controller;

import com.drivepro.db.DBConnection;
import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;

public class IncomeReportsFormController {
    public void getAllPaymentDetails(ActionEvent actionEvent) {
        try {
            JasperDesign jd = JRXmlLoader.load("D://Working Directory/First Semester Final Project/Final Project/src/com/drivepro/reports/Payments.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
    }

    }

    public void getAllOrders(){
        try {
            JasperDesign jd = JRXmlLoader.load("D://Working Directory/First Semester Final Project/Final Project/src/com/drivepro/reports/Order.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
