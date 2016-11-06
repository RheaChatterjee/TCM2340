package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.User;
import java.util.HashMap;


public class UserProfileController {
    @FXML
    private Label usernameProfile;

    @FXML
    private Label emailProfile;

    @FXML
    private Label titleProfile;

    @FXML
    private Label accountTypeProfile;

    @FXML
    private Label addressProfile;

    private User user;

    private RegistrationController registrationController;

    private Stage _dialogStage;

    private LoginController loginController;

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
        this.user = user;
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
        loginController = new LoginController();
        registrationController = new RegistrationController();
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
