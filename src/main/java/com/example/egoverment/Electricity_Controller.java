package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import java.time.LocalDate;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Electricity_Controller {

    //will it be  the same bill number if we log out and then log in with another user?
    private final int billId;
    private boolean isPaid;
    private final LocalDate dueDate;
    private final double amount;


    @FXML
    private void Backtomenu(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("User_MainMenu.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    public Electricity_Controller()
    {
        billId=generateRandomNumber(1,2000);
        dueDate = calculateDueDate();
        amount=850.00;

    }

    private LocalDate calculateDueDate() {
        YearMonth currentMonth = YearMonth.now(); // gets the current month
        return currentMonth.atEndOfMonth(); // gets the last day of the month
    }
    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    @FXML
    private ImageView ministryIcon;

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
        String billDetails = "Bill ID: " + billId + "\n" +
                "Amount: " + amount+ "\n" +
                "Due Date: " + dueDate + "\n" +
                "Status: " + (isPaid ? "Paid" : "Unpaid");
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
            String paymentStatus;
            if (isPaid) {
                paymentStatus = "This bill is already paid.";
            }
            else{
                isPaid=true;
                paymentStatus = "Payment successful for bill amount: " + amount;
            }
            showAlert("Payment Status", paymentStatus);
        } else {
            // If no input, show an error message
            showAlert("Payment Failed", "No payment details provided!");
        }
    }

}
