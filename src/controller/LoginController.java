package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.util.HashMap;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private User _user;

    private Stage _dialogStage;

    private RegistrationController registrationController;

    private boolean _login = false;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        registrationController = new RegistrationController();
    }

    /**
     * sets the dialog stage
     * @param dialogStage the given dialog stage
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
     * @param user the user you want to set
     */
    public void setUser(User user) {
        this._user = user;
    }

    /**
     * gets user
     *
     * @return user of the controller
     */
    public User getUser() {
        return _user;
    }

    /**
     * checks credentials when the okay button is pressed
     */
    @FXML
    private void handleOKPressed() {
        String username = usernameField.getText();
        HashMap<String, User> registeredUserMap = registrationController.getRegisteredUser().getRegisteredUserMap();
        User registeredUserInformation = registeredUserMap.get(username);
        if (registeredUserMap.containsKey(username) &&
                registeredUserInformation.getPassword().equals(passwordField.getText())) {
            setUser(registeredUserInformation);
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
