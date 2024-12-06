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
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.InputStream;

public class Loginer_Controller {

    @FXML
    private TextField usernameField;
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
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty()) {
            showAlert("Invalid Username", "Username must not be empty.", AlertType.ERROR);
            return;
        }
        if (!username.contains("@gmail.com")) {
            showAlert("Invalid Username", "Username must contain '@gmail.com'.", AlertType.ERROR);
            return;
        }

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
        showAlert("Success", "Login Successful!", AlertType.INFORMATION);
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
    private void goToSignUp() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            AnchorPane signUpPage = loader.load();

            SignUp_Controller signUpController = loader.getController();

            Stage signUpStage = new Stage();
            signUpStage.setTitle("Sign Up");
            signUpStage.setScene(new Scene(signUpPage));

            signUpStage.show();

            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
