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


    private Stage _dialogStage;

    private boolean _login = false;


    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
    }

    /**
     * sets the dialog stage
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * tests if the user is logged in
     * @return true if the user is logged in and false otherwise
     */
    public boolean is_login() {
        return _login;
    }

    /**
     * closes the window if the canceled button is pressed
     */
    @FXML
    private void handleCancelPressed() {
        _dialogStage.close();
    }

    /**
     * sets the default user
     * @param user
     */
    public void setUser(User user) {
        _user = user;
        _user.setUsername("user");
        _user.setPassword("pass");
    }

    /**
     * checks credentials when the okay button is pressed
     */
    @FXML
    private void handleOKPressed() {
        if (_user.getUsername().equals(usernameField.getText()) && _user.getPassword().equals(passwordField.getText())) {
            _login = true;
            _dialogStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(_dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.showAndWait();
        }

    }


}
