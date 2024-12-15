package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Loginer_Controller {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField passwordVisibleField;
    @FXML
    private Button showPasswordButton;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView eyeIcon;

    @FXML
    public void initialize() {
        // Sync text between passwordField and passwordVisibleField
        passwordVisibleField.setManaged(false);
        passwordVisibleField.setVisible(false);
        passwordVisibleField.textProperty().bindBidirectional(passwordField.textProperty());

        // Load eye icon for showing/hiding password
        InputStream imageStream = getClass().getResourceAsStream("assets/pass.jpg");
        if (imageStream == null) {
            System.out.println("Image not found: pass.jpg");
        } else {
            eyeIcon.setImage(new Image(imageStream));
        }
    }

    @FXML
    public void LoginAction(ActionEvent actionEvent) {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty()) {
            showAlert("Invalid Email", "Username must not be empty.", AlertType.ERROR);
            passwordField.clear();
            emailField.clear();
            return;
        }
        if (!email.contains(".com") || !email.contains("@")) {
            showAlert("Invalid Username", "Username must contain '@gmail.com'.", AlertType.ERROR);
            passwordField.clear();
            emailField.clear();
            return;
        }

        if (password.isEmpty()) {
            showAlert("Invalid Password", "Password must not be empty.", AlertType.ERROR);
            passwordField.clear();
            emailField.clear();
            return;
        }
        if (password.length() < 8) {
            showAlert("Invalid Password", "Password must be at least 8 characters long.", AlertType.ERROR);
            passwordField.clear();
            emailField.clear();
            return;
        }
        if (!password.matches(".*[0-9].*")) {
            showAlert("Invalid Password", "Password must contain at least one number.", AlertType.ERROR);
            passwordField.clear();
            emailField.clear();
            return;
        }
        if (!password.matches(".*[!@#$%^&*()].*")) {
            showAlert("Invalid Password", "Password must contain at least one special character.", AlertType.ERROR);
            passwordField.clear();
            emailField.clear();
            return;
        }
        if (UserCollection.search(email, password)) {
            showAlert("Success", "Login Successful!", AlertType.INFORMATION);

            try {

                URL resource = getClass().getResource("User_MainMenu.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: ");
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) actionEvent.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            } finally {
                passwordField.clear();
                emailField.clear();
            }
        } else if (OwnerCollection.search(email, password)) {
            showAlert("Success", "Login Successful!", AlertType.INFORMATION);
            try {

                URL resource = getClass().getResource("Owner_MainMenu.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: ");
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) actionEvent.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            } finally {
                passwordField.clear();
                emailField.clear();
            }
        } else {
            showAlert("failed", "failed!", AlertType.INFORMATION);
            passwordField.clear();
            emailField.clear();

        }
    }

    @FXML
    private void togglePasswordVisibility() {
        if (passwordVisibleField.isVisible()) {
            // Switch to PasswordField
            passwordVisibleField.setVisible(false);
            passwordVisibleField.setManaged(false);
            passwordField.setVisible(true);
            passwordField.setManaged(true);

            // (show password)
            InputStream imageStream = getClass().getResourceAsStream("assets/pass.jpg");
            eyeIcon.setImage(new Image(imageStream));
        } else {
            // Switch to TextField
            passwordField.setVisible(false);
            passwordField.setManaged(false);
            passwordVisibleField.setVisible(true);
            passwordVisibleField.setManaged(true);

            // (hide password)
            InputStream imageStream = getClass().getResourceAsStream("assets/pass.jpg");
            eyeIcon.setImage(new Image(imageStream));

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
    private void goToSignUp(ActionEvent event) {

        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");

        }
    }
}
