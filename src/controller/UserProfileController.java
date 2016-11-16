package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.User;


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

    private Stage _dialogStage;


    /**
     * sets the dialog stage
     * @param dialogStage dialogStage to be created
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
     * called automatically after load
     */
    @FXML
    public void initialize(User user) {
        //LoginController loginController = new LoginController();
        //RegistrationController registrationController = new RegistrationController();
        //String username = user.getUsername();
        //noinspection unchecked
        //HashMap<String, User> registeredUserInformation = registrationController.getRegisteredUser().getRegisteredUserMap();
        //User registeredUser = registeredUserInformation.get(username);
        usernameProfile.setText(user.getUsername());
        emailProfile.setText(user.getEmail());
        accountTypeProfile.setText(user.getAccountType().getName());
        addressProfile.setText(user.getAddress());
        titleProfile.setText(user.getTitle());
    }
}
