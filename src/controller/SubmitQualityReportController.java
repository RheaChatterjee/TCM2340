package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.awt.*;
import java.util.ArrayList;


public class SubmitQualityReportController {
    private User user;

    private Stage _dialogStage;

    @FXML
    private final TextField longitudeField;

    @FXML
    private final TextField latitudeField;

    @FXML
    private final TextField conditionField;

    @FXML
    private final TextField virusPPMField;

    @FXML
    private final TextField contamPPMField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private static final SubmittedQualityReports reports = new SubmittedQualityReports();

    private static SerializationController serController;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        serController = SerializationController.getInstance();
    }


    public void setUser(User user) {
        this.user = user;
    }

    /**
     * sets the dialog stage
     * @param dialogStage given dialog stage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * closes the window if the canceled button is pressed
     */
    @FXML
    private void handleCancelPressed() {
        _dialogStage.close();
    }

    /**
     * Checks for valid input
     * */
    private boolean isInputValid() {
        String errorMessage = "";
        double longitude = Double.parseDouble(longitudeField.getText());
        double latitude = Double.parseDouble(latitudeField.getText());
        //for now just check they actually typed something
        if (longitudeField.getText() == null || longitudeField.getText().length() == 0) {
            errorMessage += "No valid location entered!\n";
        }
        if (latitudeField.getText() == null || longitudeField.getText().length() == 0) {
            errorMessage += "No valid location entered!\n";
        }
        InputChecker checker = new InputChecker();
        errorMessage += checker.checkQualReportInput(longitude, latitude, conditionField.getText(), virusPPMField.getText(), contamPPMField.getText());
        //no error message means success / good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(_dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    /** Creates a new quality report and instance of location for the report
     */
    @FXML
    private void handleSubmitQualityReport() {
        serController.retrieveChanges("waterQualityReports");
        ArrayList<WaterQualityReport> reportList = SerializationController.waterQualityReports;
        double longitude = Double.parseDouble(longitudeField.getText());
        double latitude = Double.parseDouble(latitudeField.getText());
        Location loc = new Location(latitude, longitude, virusPPMField.getText(), "<h2>Type: " + contamPPMField.getText() + "<br> Condition: " + conditionField.getText());
        WaterQualityReport report = new WaterQualityReport(user.getUsername(), loc, conditionField.getText(), virusPPMField.getText(), contamPPMField.getText());
        if (isInputValid()) {
            reportList.add(report);
            //reports.addQualityReport(report);
            _dialogStage.close();
        }
    }
}
