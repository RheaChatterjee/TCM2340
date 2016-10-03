package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

/**
 * Created by Elizabeth on 10/2/2016.
 */
public class EditProfileController {
    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField titleField;

    private User user;

    private Stage _dialogStage;

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
    private void handleEditProfile() {
        user.setPassword(passwordField.getText());
        user.setAddress(addressField.getText());
        user.setEmail(emailField.getText());
        user.setTitle(titleField.getText());
        _dialogStage.close();
    }
}
