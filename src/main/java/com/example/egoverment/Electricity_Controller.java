package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Electricity_Controller {

    @FXML
    private void handleCheckBill() {
        // Logic to handle the 'Check Bill' action
        System.out.println("Checking the bill...");
        showAlert("Bill Details", "Here are your bill details...");
    }

    @FXML
    private void handlePayBill() {
        // Logic to handle the 'Pay Bill' action
        System.out.println("Paying the bill...");
        showAlert("Bill Payment", "Your bill has been paid!");
    }

    @FXML
    private void handleLogout() {
        // Logic to handle 'Log Out'
        System.out.println("Logging out...");
        showAlert("Logout", "You have successfully logged out.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
