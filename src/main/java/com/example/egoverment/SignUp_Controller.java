package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp_Controller {

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField rewritePasswordField;

    @FXML
    private Button signUpButton;

    // Visible text fields for showing password in plain text
    @FXML
    private TextField passwordVisibleField;

    @FXML
    private TextField rewritepassVisibleField;

    // Method that is triggered when the "Sign Up" button is clicked
    @FXML
    private void SignUpAction() {
        String name = nameField.getText();
        String nationalId = idField.getText();
        String address = addressField.getText();
        String mobileNumber = mobileField.getText();
        String username = userField.getText();
        String password = passwordField.getText();
        String reWritePassword = rewritePasswordField.getText();

        // Validate fields
        if (name.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
                mobileNumber.isEmpty() || username.isEmpty() || password.isEmpty() || reWritePassword.isEmpty()) {
            showAlert("Error", "All fields must be filled out!");
        } else if (!password.equals(reWritePassword)) {
            showAlert("Error", "Passwords do not match!");
        } else if (!isValidMobileNumber(mobileNumber)) {
            showAlert("Error", "Mobile number must have 11 digits and start with 0 and 1.");
        } else if (!isValidNationalId(nationalId)) {
            showAlert("Error", "National ID must have 14 digits.");
        } else if (!isValidUsername(username)) {
            showAlert("Error", "Username must contain @gmail.com.");
        } else if (!isValidPassword(password)) {
            showAlert("Error", "Password must be at least 8 characters long, contain a symbol, and a number.");
        } else {
            // Proceed with sign-up logic (e.g., saving data or interacting with a database)
            showAlert("Success", "You have signed up successfully!");
        }
    }

    // Helper method to show alerts with a cross icon
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR); // Use ERROR type to display cross icon
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Validate mobile number (11 digits, starting with 0 and 1)
    private boolean isValidMobileNumber(String mobile) {
        Pattern pattern = Pattern.compile("^[01][0-9]{10}$");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    // Validate national ID (14 digits)
    private boolean isValidNationalId(String id) {
        Pattern pattern = Pattern.compile("^\\d{14}$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    // Validate username (must contain @gmail.com)
    private boolean isValidUsername(String username) {
        return username.contains("@gmail.com");
    }

    // Validate password (must have a symbol, a number, and be at least 8 characters)
    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    @FXML
    private void GoBack() {
        try {
            // Load the SignUp FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Loginer.fxml"));
            AnchorPane signUpPage = loader.load();

            // Get the SignUp controller (optional)
            Loginer_Controller gobackController = loader.getController();

            // Create a new stage (window) for the SignUp page
            Stage gobackStage = new Stage();
            gobackStage.setTitle("Sign Up");
            gobackStage.setScene(new Scene(signUpPage));

            // Show the SignUp window
            gobackStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
