package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;


public class SubmitQualityReportController {
    private User user;

    private Stage _dialogStage;

    @FXML
    private TextField longitudeField;

    @FXML
    private TextField latitudeField;

    @FXML
    private TextField conditionField;

    @FXML
    private TextField virusPPMField;

    @FXML
    private TextField contamPPMField;

    private static final SubmittedQualityReports reports = new SubmittedQualityReports();


    public void setUser(User user) {
        this.user = user;
    }

    /**
     * sets the dialog stage
     * @param dialogStage
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
    public boolean isInputValid() {
        String errorMessage = "";
        double longitude = Double.parseDouble(longitudeField.getText().toString());
        double latitude = Double.parseDouble(latitudeField.getText().toString());
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
        if (latitude > 90 || latitude < -180) {
            errorMessage += "Latitude field is invalid!\n";
        }
        if (conditionField.getText() == null || conditionField.getText().length() == 0) {
            errorMessage += "No valid water condition entered!\n";
        }
        if (virusPPMField.getText() == null || virusPPMField.getText().length() == 0) {
            errorMessage += "No valid virusPPM entered!\n";
        }
        if (contamPPMField.getText() == null || contamPPMField.getText().length() == 0) {
            errorMessage += "No valid contamPPM entered!\n";
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

    /** Creates a new quality report and instance of location for the report
     */
    @FXML
    private void handleSubmitQualityReport() {
        double longitude = Double.parseDouble(longitudeField.getText().toString());
        double latitude = Double.parseDouble(latitudeField.getText().toString());
        Location loc = new Location(latitude, longitude, virusPPMField.getText(), "<h2>Type: " + contamPPMField.getText() + "<br> Condition: " + conditionField.getText());
        WaterQualityReport report = new WaterQualityReport(user.getUsername(), loc, conditionField.getText(), virusPPMField.getText(), contamPPMField.getText());
        if (isInputValid()) {
            reports.addQualityReport(report);
            _dialogStage.close();
        }
    }
}
