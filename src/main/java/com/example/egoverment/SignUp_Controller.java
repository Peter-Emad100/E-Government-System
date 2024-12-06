package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp_Controller {

    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField emailField;
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
    @FXML
    private TextField passwordVisibleField;
    @FXML
    private TextField RepasswordVisibleField;
    @FXML
    private ImageView eyeIcon;
    @FXML
    private ImageView eyeIcon2;

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void SignUpAction() {
        long nationalId=0;
        String name = nameField.getText();
         try{nationalId =Long.parseLong(idField.getText());}
        catch (Exception e){
             System.out.println(e);
        }
        String mail = emailField.getText();
        String mobileNumber = mobileField.getText();
        String username = userField.getText();
        String password = passwordField.getText();
        String reWritePassword = rewritePasswordField.getText();

        if (name.isEmpty() || nationalId==0 || mail.isEmpty() ||
                mobileNumber.isEmpty() || username.isEmpty() || password.isEmpty() || reWritePassword.isEmpty()) {
            showAlert("Error", "All fields must be filled out!", Alert.AlertType.ERROR);
        } else if (!password.equals(reWritePassword)) {
            showAlert("Error", "Passwords do not match!", Alert.AlertType.ERROR);
        } else if (!isValidMobileNumber(mobileNumber)) {
            showAlert("Error", "Mobile number must have 11 digits and start with 0 and 1.", Alert.AlertType.ERROR);
        } else if (!isValidNationalId(nationalId)) {
            showAlert("Error", "National ID must have 14 digits.", Alert.AlertType.ERROR);
        } else if (!isValidMail(mail)) {
            showAlert("Error", "mail must contain @ && .com.", Alert.AlertType.ERROR);
        } else if (!isValidPassword(password)) {
            showAlert("Error", "Password must be at least 8 characters long, contain a symbol, and a number.", Alert.AlertType.ERROR);
        } else {
            // Proceed with sign-up logic (e.g., saving data or interacting with a database)
            UserCollection.add(name,nationalId,username,password,mobileNumber,mail);
            showAlert("Success", "You have signed up successfully!", Alert.AlertType.INFORMATION);
        }
    }

    private boolean isValidMobileNumber(String mobile) {
        Pattern pattern = Pattern.compile("^[01][0-9]{10}$");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    private boolean isValidNationalId(Long id) {
        //Pattern pattern = Pattern.compile("^\\d{14}$");
        //Matcher matcher = pattern.matcher(id);
        //return matcher.matches();
        int length = String.valueOf(id).length();
        return length == 14;
    }

    private boolean isValidMail(String mail) {
        return mail.contains(".com") && mail.contains("@");

    }

    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
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
            InputStream imageStream = getClass().getResourceAsStream("/pass.png");
            if (imageStream != null) {
                eyeIcon.setImage(new Image(imageStream));
            }
        } else {
            // Switch to TextField
            passwordField.setVisible(false);
            passwordField.setManaged(false);
            passwordVisibleField.setVisible(true);
            passwordVisibleField.setManaged(true);
        }
    }

    @FXML
    private void toggleRePasswordVisibility() {
        if (RepasswordVisibleField.isVisible()) {
            // Switch to PasswordField
            RepasswordVisibleField.setVisible(false);
            RepasswordVisibleField.setManaged(false);
            rewritePasswordField.setVisible(true);
            rewritePasswordField.setManaged(true);

            // (show password)
            InputStream imageStream = getClass().getResourceAsStream("/repass.png");
            if (imageStream != null) {
                eyeIcon2.setImage(new Image(imageStream));
            }
        } else {
            // Switch to TextField
            rewritePasswordField.setVisible(false);
            rewritePasswordField.setManaged(false);
            RepasswordVisibleField.setVisible(true);
            RepasswordVisibleField.setManaged(true);
        }
    }

    @FXML
    public void initialize() {
        // Sync text between passwordField and passwordVisibleField
        passwordVisibleField.setManaged(false);
        passwordVisibleField.setVisible(false);
        passwordVisibleField.textProperty().bindBidirectional(passwordField.textProperty());

        // Load eye icon for showing/hiding password
        InputStream imageStream = getClass().getResourceAsStream("/pass.png");
        if (imageStream == null) {
            System.out.println("Image not found: pass.png");
        } else {
            eyeIcon.setImage(new Image(imageStream));
        }

        // Sync text between rewritePasswordField and RepasswordVisibleField
        RepasswordVisibleField.setManaged(false);
        RepasswordVisibleField.setVisible(false);
        RepasswordVisibleField.textProperty().bindBidirectional(rewritePasswordField.textProperty());

    }

    @FXML
    private void GoBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Loginer.fxml"));
            AnchorPane signUpPage = loader.load();

            Loginer_Controller gobackController = loader.getController();

            Stage gobackStage = new Stage();
            gobackStage.setTitle("Log In");
            gobackStage.setScene(new Scene(signUpPage));

            gobackStage.show();
            Stage currentStage = (Stage) nameField.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
