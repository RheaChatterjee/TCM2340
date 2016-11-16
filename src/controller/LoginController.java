package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    @FXML
    private final TextField usernameField;

    @FXML
    private final TextField passwordField;

    private User _user;

    private Stage _dialogStage;

    private RegistrationController registrationController;

    private boolean _login = false;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        SerializationController serController = SerializationController.getInstance();
        ArrayList<User> userList = SerializationController.users;
        System.out.println("loaded " + userList.size() + " users.");
        registrationController = new RegistrationController();
        System.out.println(userList.size());
        Map<String, User> registeredUserMap = registrationController.getRegisteredUser().getRegisteredUserMap();
        for (User user : userList) {
            System.out.println(user.getUsername() + " " + user.getPassword());
            registeredUserMap.put(user.getUsername(), user);
        }
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
