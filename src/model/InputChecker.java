package model;

public class InputChecker {
    public InputChecker() {

    }
    public String checkRegistrationInput(String name, String password, String email, String type, String address, String title) {
        String errorMessage = "";
        if (name == null || name.length() == 0) {
            errorMessage += "Not a valid username!\n";
        }
        if (password == null || password.length() < 4) {
            errorMessage += "No valid password entered! Please make password longer than four characters! \n";
        }
        if (email == null || email.length() == 0 || !email.contains("@")) {
            errorMessage += "No valid email entered!\n";
        }
        if (type == null) {
            errorMessage += "No valid account type selected\n";
        }
        if (address == null || address.length() == 0) {
            errorMessage += "No valid address entered!\n";
        }
        if (title == null || title.length() == 0) {
            errorMessage += "No valid title entered!\n";
        }
        return errorMessage;
    }

    public String checkQualReportInput(double longitude, double latitude, String condition, String virusPPM, String contamPPM) {
        String errorMessage = "";
        if (longitude > 180 || longitude < -180) {
            errorMessage += "Longitude field is invalid!\n";
        }
        if (latitude > 90 || latitude < -90) {
            errorMessage += "Latitude field is invalid!\n";
        }
        if (condition == null || condition.length() == 0) {
            errorMessage += "No valid water condition entered!\n";
        }
        if (virusPPM == null || virusPPM.length() == 0) {
            errorMessage += "No valid virusPPM entered!\n";
        }
        if (contamPPM == null || contamPPM.length() == 0) {
            errorMessage += "No valid contamPPM entered!\n";
        }
        return errorMessage;
    }

    public String checkReportInput(double longitude, double latitude, String condition, String type) {
        String errorMessage = "";
        if (longitude > 180 || longitude < -180) {
            errorMessage += "Longitude field is invalid!\n";
        }
        if (latitude > 90 || latitude < -90) {
            errorMessage += "Latitude field is invalid!\n";
        }
        if (condition == null || condition.length() == 0) {
            errorMessage += "No valid water condition entered!\n";
        }
        if (type == null || type.length() == 0) {
            errorMessage += "No type entered!\n";
        }
        return errorMessage;
    }

    public boolean checkEmail(String email) {
        if (email.length() > 2 && email.contains("@") && email.contains(".")) {
            return true;
        } else {
            return false;
        }
    }
}
