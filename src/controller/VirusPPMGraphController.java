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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import model.Report;
import model.SubmittedQualityReports;
import model.SubmittedReports;
import model.WaterQualityReport;

import java.awt.*;
import java.util.ArrayList;


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

    private ArrayList<WaterQualityReport> reportListGraph = new ArrayList<>();

    private ArrayList<WaterQualityReport> reportArrayList = SubmittedQualityReports.getSubmittedQualityReports();

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


    @Override
    public void start(Stage stage) {
        stage.setTitle("VirusPPM History Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");

        final LineChart<String, Number> lineChart =
                new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setTitle("VirusPPM History");

        XYChart.Series series = new XYChart.Series();
        series.setName("VirusPPM");



//        series.getData().add(new XYChart.Data("Jan", 23));
//        series.getData().add(new XYChart.Data("Feb", 14));
//        series.getData().add(new XYChart.Data("Mar", 15));
//        series.getData().add(new XYChart.Data("Apr", 24));
//        series.getData().add(new XYChart.Data("May", 34));
//        series.getData().add(new XYChart.Data("Jun", 36));
//        series.getData().add(new XYChart.Data("Jul", 22));
//        series.getData().add(new XYChart.Data("Aug", 45));
//        series.getData().add(new XYChart.Data("Sep", 43));
//        series.getData().add(new XYChart.Data("Oct", 17));
//        series.getData().add(new XYChart.Data("Nov", 29));
//        series.getData().add(new XYChart.Data("Dec", 25));


        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }
}