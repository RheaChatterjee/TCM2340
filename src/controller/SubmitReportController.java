package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import java.util.ArrayList;


public class SubmitReportController {
    private User user;

    private Stage _dialogStage;

    @FXML
    private TextField longitudeField;

    @FXML
    private TextField latitudeField;

    @FXML
    private TextField conditionField;

    @FXML
    private TextField typeField;

    private static final SubmittedReports reports = new SubmittedReports();

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
        if (longitude > 180 || longitude < -180) {
            errorMessage += "Longitude field is invalid!\n";
        }
        if (latitude > 90 || latitude < -90) {
            errorMessage += "Latitude field is invalid!\n";
        }
        if (conditionField.getText() == null || conditionField.getText().length() == 0) {
            errorMessage += "No valid water condition entered!\n";
        }
        if (typeField.getText() == null || typeField.getText().length() == 0) {
            errorMessage += "No valid water type entered!\n";
        }
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

    /** Creates a new report and instance of location for the report
     */
    @FXML
    private void handleSubmitReport() {
        serController.retrieveChanges("reports");
        ArrayList<Report> reportList = SerializationController.reports;
        double longitude = Double.parseDouble(longitudeField.getText());
        double latitude = Double.parseDouble(latitudeField.getText());
        Location loc = new Location(latitude, longitude, typeField.getText(), "<h2>Type: " + typeField.getText() + "<br> Condition: " + conditionField.getText());
        Report report = new Report(user.getUsername(), loc, typeField.getText(), conditionField.getText());
        if (isInputValid()) {
            serController.retrieveChanges("reports");
            reportList.add(report);
            serController.saveChanges("reports", SerializationController.reports);
            //reports.addReport(report);
            _dialogStage.close();
        }
    }
}
