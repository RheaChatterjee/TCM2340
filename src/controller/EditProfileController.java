package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.InputChecker;
import model.User;

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
     * @param dialogStage the given dialog stage
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
     * handles editing user profile
     */
    @FXML
    private void handleEditProfile() {
        InputChecker checker = new InputChecker();
        if (checker.checkEmail(emailField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(_dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("Invalid email address");

            alert.showAndWait();
        } else if (emailField.getText().length() != 0) {
            user.setEmail(emailField.getText());
        }
        if (passwordField.getText() == null || passwordField.getText().length() >= 4) {
            user.setPassword(passwordField.getText());
        }
        if (addressField.getText() == null || addressField.getText().length() != 0) {
            user.setAddress(addressField.getText());
        }
        if (titleField.getText() == null || titleField.getText().length() != 0) {
            user.setTitle(titleField.getText());
        }
        _dialogStage.close();
    }
}
