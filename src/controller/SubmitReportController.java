package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.AccountType;
import model.Report;
import model.SubmittedReports;
import model.User;

/**
 * Created by Elizabeth on 10/11/2016.
 */
public class SubmitReportController {
    private User user;

    private Stage _dialogStage;

    @FXML
    private TextField locationField;

    @FXML
    private TextField conditionField;

    @FXML
    private TextField typeField;

    private static final SubmittedReports reports = new SubmittedReports();


    @FXML
    private void initialize() {

    }

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

        //for now just check they actually typed something
        if (locationField.getText() == null || locationField.getText().length() == 0) {
            errorMessage += "No valid location entered!\n";
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



    @FXML
    private void handleSubmitReport() {
        Report report = new Report(user.getUsername(), locationField.getText(), conditionField.getText(), typeField.getText());
        if (isInputValid()) {
            reports.addReport(report);
            _dialogStage.close();
        }
    }
}
