package com.example.egoverment;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;

public class MinistryOfHealthAndPopulationController {



    @FXML
    private ComboBox<BloodType> BloodTypeIn;

    @FXML
    private TextField QuantityIn;

    private MinistryOfHealthAndPopulation ministry;

    @FXML
    public void initialize() {
        BloodTypeIn.setValue(BloodType.A_POS);
        BloodTypeIn.getItems().addAll(BloodType.values());
    }
    public void setMinistry(MinistryOfHealthAndPopulation ministry) {
        this.ministry = ministry;
    }

    @FXML
    void searchBloodBanksOnClick(MouseEvent event) {
        try {

            BloodType selectedType = BloodTypeIn.getValue();
            if (selectedType == null) {
                showAlert("Error", "Please select a blood type!", AlertType.ERROR);
                return;
            }


            String quantityText = QuantityIn.getText();
            if (quantityText.isEmpty()) {
                showAlert("Error", "Please enter the required quantity!", AlertType.ERROR);
                return;
            }


            int requiredQuantity;
            try {
                requiredQuantity = Integer.parseInt(quantityText);
                if (requiredQuantity <= 0) {
                    showAlert("Error", "Quantity must be a positive number!", AlertType.ERROR);
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Quantity must be a valid number!", AlertType.ERROR);
                return;
            }


            List<BloodBank> matchingBanks = ministry.searchBloodBanks(selectedType, requiredQuantity);


            if (matchingBanks.isEmpty()) {
                showAlert("Search Result", "No blood banks found matching the criteria.", AlertType.INFORMATION);
            } else {
                StringBuilder resultMessage = new StringBuilder("Matching Blood Banks:\n");
                for (BloodBank bank : matchingBanks) {
                    resultMessage.append("- ").append(bank.getLocation()).append("\n");
                }
                showAlert("Search Result", resultMessage.toString(), AlertType.INFORMATION);
            }
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage(), AlertType.ERROR);
        }
    }


    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
