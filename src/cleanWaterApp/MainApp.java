package cleanWaterApp;

import controller.LoginController;
import controller.WelcomeScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends Application {

    /**  the java logger for this class */
    private static final Logger LOGGER =Logger.getLogger("cleanWaterApp");

    /** the main container for the application window */
    private Stage mainScreen;

    /** the main layout for the main window */
    private GridPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
    }

    public Stage getMainScreen() { return mainScreen;}

    private void initRootLayout(Stage mainScreen) {
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/welcome.fxml"));
            rootLayout = loader.load();


            WelcomeScreenController controller = new WelcomeScreenController();
            loader.setController(controller);
            controller.setMainApp(this);


            // Set the cleanWaterApp App title
            mainScreen.setTitle("Course Registration");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();


        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for WelcomeScreen!!");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void showLoginWindow() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/login.fxml"));
            AnchorPane page = loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Login");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            LoginController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
