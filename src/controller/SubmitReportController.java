package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
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

    @FXML
    private void handleSubmitReport() {
        Report report = new Report(user.getUsername(), locationField.getText(), conditionField.getText(), typeField.getText());
        reports.addReport(report);
    }
}
