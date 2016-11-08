package controller;

/**
 * Created by David on 11/6/2016.
 */
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Report;
import model.SubmittedQualityReports;
import model.SubmittedReports;
import model.WaterQualityReport;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class VirusPPMGraphController extends Application {

    @FXML
    private RadioButton containmentButton;

    @FXML
    private RadioButton virusButton;

    @FXML
    private TextField yearText;

    @FXML
    private TextField latitude;

    @FXML
    private TextField longitude;

    private Stage stage;


    private ArrayList<WaterQualityReport> reportListGraph = new ArrayList<>();

    private ArrayList<WaterQualityReport> reportArrayList = SubmittedQualityReports.getSubmittedQualityReports();



    public void setDialogStage(Stage dialogStage) {
        stage = dialogStage;
    }

    /**
     * gets the year selected
     * @return String year user selected
     */
    private String getYear() {
        return yearText.getText();
    }

    /**
     * gets the latitude entered
     * @return double latitude entered
     */
    private double getLatitude() {
        return Double.parseDouble(latitude.getText());
    }

    /**
     * gets the longitude entered
     * @return double longitude entered
     */
    private double getLongitude() {
        return Double.parseDouble(longitude.getText());
    }

    public ArrayList<WaterQualityReport> getWaterQualityData() {
        for (WaterQualityReport report : reportArrayList) {
            if ((report.getYear().equals(yearText.getText()))
                && (report.getLocation().getLatitude() == getLatitude())
                && report.getLocation().getLongitude() == getLongitude()) {
                reportListGraph.add(report);
            }
        }
        return reportListGraph;
    }

    public void drawGraph() {
        start(stage);
    }

    @Override
    public void start(Stage stage) {
        if (virusButton.isSelected()) {
            stage.setTitle("VirusPPM History Chart");
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Month");

            final LineChart<String, Number> viruslineChart =
                    new LineChart(xAxis, yAxis);

            viruslineChart.setTitle("VirusPPM History");

            XYChart.Series virusSeries = new XYChart.Series();
            virusSeries.setName("VirusPPM");

            HashMap<String, Integer> data = new HashMap<>();
            for (WaterQualityReport report : getWaterQualityData()) {
                if (data.get(report.getMonth()) == null) {
                    data.put(report.getMonth(), Integer.parseInt(report.getVirusPPM()));
                } else {
                    data.put(report.getMonth(), (data.get(report.getMonth())+Integer.parseInt(report.getVirusPPM()))/2);
                }
            }
            System.out.println(data.size());
            for (String key : data.keySet()) {
                virusSeries.getData().add(new XYChart.Data(key, data.get(key)));
            }
            /*for (WaterQualityReport report : getWaterQualityData()) {
                virusSeries.getData().add(new XYChart.Data(report.getMonth(), Integer.parseInt(report.getVirusPPM())));
            }*/


            Scene scene = new Scene(viruslineChart, 800, 600);
            viruslineChart.getData().add(virusSeries);

            stage.setScene(scene);
            stage.show();
        }
        if (containmentButton.isSelected()) {
            stage.setTitle("ContaminantPPM History Chart");
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Month");

            final LineChart<String, Number> viruslineChart =
                    new LineChart(xAxis, yAxis);

            viruslineChart.setTitle("ContaminantPPM History");

            XYChart.Series contamSeries = new XYChart.Series();
            contamSeries.setName("ContaminantPPM");

            HashMap<String, Integer> data = new HashMap<>();
            for (WaterQualityReport report : getWaterQualityData()) {
                if (data.get(report.getMonth()) == null) {
                    data.put(report.getMonth(), Integer.parseInt(report.getContamPPM()));
                } else {
                    data.put(report.getMonth(), (data.get(report.getMonth()) + Integer.parseInt(report.getContamPPM())) / 2);
                }
            }
            System.out.println(data.size());
            for (String key : data.keySet()) {
                contamSeries.getData().add(new XYChart.Data(key, data.get(key)));
            }


            Scene scene = new Scene(viruslineChart, 800, 600);
            viruslineChart.getData().add(contamSeries);
            stage.setScene(scene);
            stage.show();
        }


    }
}
