package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User;

import java.util.ArrayList;

/**
 * Created by Elizabeth on 9/20/2016.
 */
public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private User _user;


    /** the window for this dialog */
    private Stage _dialogStage;

    private boolean _okClicked = false;


    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return _okClicked;
    }


    @FXML
    private void handleCancelPressed() {
        _dialogStage.close();
    }

    public void setUser(User user) {
        _user = user;
        _user.setUsername("user");
        _user.setPassword("pass");
    }

    @FXML
    private void handleOKPressed() {
        if (_user.getUsername().equals(usernameField.getText()) && _user.getPassword().equals(passwordField.getText())) {
            _dialogStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(_dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.showAndWait();
        }
        _okClicked = true;
    }


}
