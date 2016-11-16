package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.User;

import java.util.HashMap;


public class UserProfileController {
    @FXML
    private final Label usernameProfile;

    @FXML
    private final Label emailProfile;

    @FXML
    private final Label titleProfile;

    @FXML
    private final Label accountTypeProfile;

    @FXML
    private final Label addressProfile;

    private Stage _dialogStage;

    /**
     * sets the dialog stage
     * @param dialogStage dialogStage to be created
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * sets class user
     * @param user the user that will be set
     */
    public void setUser(User user) {
    }

    /**
     * closes the window if the canceled button is pressed
     */
    @FXML
    private void handleCancelPressed() {
        _dialogStage.close();
    }

    /**
     * called automatically after load
     */
    @FXML
    public void initialize(User user) {
        LoginController loginController = new LoginController();
        RegistrationController registrationController = new RegistrationController();
        setUser(loginController.getUser());
        String username = user.getUsername();
        HashMap<String, User> registeredUserInformation = registrationController.getRegisteredUser().getRegisteredUserMap();
        User registeredUser = registeredUserInformation.get(username);
        usernameProfile.setText(user.getUsername());
        emailProfile.setText(user.getEmail());
        accountTypeProfile.setText(user.getAccountType().getName());
        addressProfile.setText(user.getAddress());
        titleProfile.setText(user.getTitle());
    }
}
