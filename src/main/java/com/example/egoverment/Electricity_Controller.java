package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class Electricity_Controller {

    @FXML
    private ImageView ministryIcon;

    private final MinistryOfElectricity ministry = new MinistryOfElectricity();

    @FXML
    public void initialize() {
        try {
            ministryIcon.setImage(new Image(getClass().getResource("/com/example/egoverment/assets/min_electricity_icon.jpg").toExternalForm()));
        } catch (Exception e) {
            System.out.println("Failed to load image: " + e.getMessage());
        }
    }

//    @FXML
//    private void handleCheckBill() {
//        ElectricityBill bill = ministry.getCurrentBill();
//        String billDetails = String.format("Amount: $%.2f\nDue Date: %s\nStatus: %s",
//                bill.getAmount(),
//                bill.getDueDate(),
//                bill.isPaid() ? "Paid" : "Unpaid");
//
//        showAlert("Bill Details", billDetails);
//    }
//
//    @FXML
//    private void handlePayBill() {
//        // Prompt for payment details
//        TextInputDialog dialog = new TextInputDialog();
//        dialog.setTitle("Payment Details");
//        dialog.setHeaderText("Enter your payment details");
//        dialog.setContentText("Card Number:");
//
//        Optional<String> result = dialog.showAndWait();
//        result.ifPresent(cardNumber -> {
//            // Simulate payment and display success message
//            ministry.payCurrentBill();
//            showAlert("Payment Successful", "Your bill has been successfully paid!");
//        });
//    }

    @FXML
    private void handleLogout() {
        showAlert("Logout", "You have successfully logged out.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    // Method to handle bill checking and display its details
    @FXML
    private void handleCheckBill() {
        // Fetch current bill details from MinistryOfElectricity
        String billDetails = ministry.getCurrentBillDetails();
        showAlert("Bill Details", billDetails);
    }

    // Method to handle bill payment with payment details
    @FXML
    private void handlePayBill() {
        // Prompt user for payment details
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Payment Details");
        dialog.setHeaderText("Enter Your Payment Details");
        dialog.setContentText("Payment Info:");

        // Show dialog and wait for user input
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent() && !result.get().trim().isEmpty()) {
            // Process payment after valid input
            String paymentStatus = ministry.payCurrentBill();
            showAlert("Payment Status", paymentStatus);
        } else {
            // If no input, show an error message
            showAlert("Payment Failed", "No payment details provided!");
        }
    }

}
