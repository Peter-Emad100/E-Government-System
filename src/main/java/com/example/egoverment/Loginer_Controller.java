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

public class Loginer_Controller {

    @FXML
    private TextField usernameField; // For Username/Email input

    @FXML
    private PasswordField passwordField; // For Password input

    @FXML
    private TextField passwordVisibleField; // For showing password (toggle field)

    @FXML
    private Button showPasswordButton; // Show/Hide Password button

    @FXML
    private Button loginButton; // Login button (optional, if needed for other purposes)

    // Initialize method to configure fields
    @FXML
    public void initialize() {
        // Sync content between passwordField and passwordVisibleField
        passwordVisibleField.setManaged(false);
        passwordVisibleField.setVisible(false);

        // Bind text between passwordField and passwordVisibleField
        passwordVisibleField.textProperty().bindBidirectional(passwordField.textProperty());
    }

    // Action method when login button is clicked
    @FXML
    public void LoginAction(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate username
        if (username.isEmpty()) {
            showAlert("Invalid Username", "Username must not be empty.", AlertType.ERROR);
            return;
        }
        if (!username.contains("@gmail.com")) {
            showAlert("Invalid Username", "Username must contain '@gmail.com'.", AlertType.ERROR);
            return;
        }

        // Validate password
        if (password.isEmpty()) {
            showAlert("Invalid Password", "Password must not be empty.", AlertType.ERROR);
            return;
        }
        if (password.length() < 8) {
            showAlert("Invalid Password", "Password must be at least 8 characters long.", AlertType.ERROR);
            return;
        }
        if (!password.matches(".*[0-9].*")) {
            showAlert("Invalid Password", "Password must contain at least one number.", AlertType.ERROR);
            return;
        }
        if (!password.matches(".*[!@#$%^&*()].*")) {
            showAlert("Invalid Password", "Password must contain at least one special character.", AlertType.ERROR);
            return;
        }

        // If all validations pass, proceed with further actions (e.g., authentication)
        showAlert("Success", "Login Successful!", AlertType.INFORMATION);
    }

    // Action method for toggling password visibility
    @FXML
    public void togglePasswordVisibility(ActionEvent actionEvent) {
        if (passwordVisibleField.isVisible()) {
            // Switch to PasswordField
            passwordVisibleField.setVisible(false);
            passwordVisibleField.setManaged(false);
            passwordField.setVisible(true);
            passwordField.setManaged(true);
            showPasswordButton.setText("Show Password");
        } else {
            // Switch to TextField
            passwordField.setVisible(false);
            passwordField.setManaged(false);
            passwordVisibleField.setVisible(true);
            passwordVisibleField.setManaged(true);
            showPasswordButton.setText("Hide Password");
        }
    }

    // Helper method to show alert messages
    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    private void goToSignUp() {
        try {
            // Load the SignUp FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            AnchorPane signUpPage = loader.load();

            // Get the SignUp controller (optional)
            SignUp_Controller signUpController = loader.getController();

            // Create a new stage (window) for the SignUp page
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Sign Up");
            signUpStage.setScene(new Scene(signUpPage));

            // Show the SignUp window
            signUpStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
