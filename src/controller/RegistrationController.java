package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.AccountType;
import javafx.scene.control.TextField;
import model.InputChecker;
import model.RegisteredUser;
import model.User;



public class RegistrationController {

    @FXML
    private TextField registrationName;

    @FXML
    private TextField registrationEmail;

    @FXML
    private TextField registrationPassword;

    @FXML
    private TextField addressBox;

    @FXML
    private TextField titleBox;

    @FXML
    private ComboBox<AccountType> selectAccountType;

    private static final RegisteredUser registeredUser = new RegisteredUser();

    private Stage registrationStage;

    private boolean registered;

    private User user;


    /**
     * called automatically after
     * Initializes list of account types on registration page
     */
    @FXML
    private void initialize() {
        selectAccountType.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                selectAccountType.requestFocus();
            }
        });
        selectAccountType.setItems(AccountType.getAccountTypeList());
    }

    /**
     * sets the dialog stage
     * @param dialogStage dialogStage to be created
     */
    public void setDialogStage(Stage dialogStage) {
        registrationStage = dialogStage;
    }

    /**
     * tests if the user registered
     * @return true if the user is registered successfully
     */
    public boolean is_login() {
        return registered;
    }


    /**
     * returns instance of registered user
     * @return RegisteredUser
     */
    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    /**
     * Cancels registration and closes registration window
     *
     */
    @FXML
    private void handleCancelPressed() {
        registrationStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";
        InputChecker checker = new InputChecker();
        //for now just check they actually typed something
        if (registeredUser.usernameExist(user)) {
            errorMessage += "Username already exists!\n";
        }
        errorMessage += checker.checkRegistrationInput(registrationName.getText(), registrationPassword.getText(), registrationEmail.getText(), selectAccountType.getValue().toString(), addressBox.getText(), titleBox.getText());
        //no error message means success / good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(registrationStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    /** checks credentials when the okay button is pressed
    */
    @FXML
    private void handleOKPressed() {

        this.user = new User(registrationName.getText(), registrationPassword.getText(), "tempID", registrationEmail.getText(), selectAccountType.getValue(), addressBox.getText(), titleBox.getText());
        if (isInputValid()) {
            registeredUser.addUser(user);
            registered = true;
            registrationStage.close();
        }
    }

}

