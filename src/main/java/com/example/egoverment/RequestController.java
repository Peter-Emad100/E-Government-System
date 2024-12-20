package com.example.egoverment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

public class RequestController {
    String formName=showDepartmentsController.selectedForm;

    @FXML
    private Label outputLabel;

    @FXML
    private TextField addressField;

    @FXML
    private Button bckbutton;

    @FXML
    private DatePicker birthdateField;

    @FXML
    private TextField commentsField;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField idField;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private TextField nameField;

    @FXML
    private Button submitButton;

    private boolean gendertype;

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

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void returnToOriginal()
    {
        gender.selectToggle(null);
        birthdateField.setValue(null);
        nameField.setText(null);
        idField.setText(null);
        commentsField.setText(null);
        addressField.setText(null);
    }


    @FXML
    void SubmitRequest(MouseEvent event) {
        LocalDate selectedDate = birthdateField.getValue();

        //gender knowing
        RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedText = selectedRadioButton.getText();
            if(selectedText.equals(maleRadio.getText()))
            {
                gendertype=true;
            }
            else {
                gendertype=false;
            }

        } else {
            outputLabel.setText("No option selected.");
        }

        // Check if the date is null or less than 2024
        if (selectedDate == null || selectedDate.getYear() >= 2024) {
            // Show an alert if the date is invalid
            showAlert("Alert", "Can't submit request, please select a valid date", Alert.AlertType.ERROR);
            returnToOriginal();
        }

        //make sure that texts aren't submitted null except for comments
        else if(addressField.getText() != null && !addressField.getText().trim().isEmpty()
                && nameField.getText() != null && !nameField.getText().trim().isEmpty()
                && idField.getText() != null && !idField.getText().trim().isEmpty()
                && birthdateField.getValue() != null)
        {
            RequestCollection.addRequest(formName, nameField.getText(), idField.getText(),
                    commentsField.getText(), addressField.getText(),birthdateField.getValue().toString(), gendertype);


            showAlert("Message", "Request submitted successfully", Alert.AlertType.CONFIRMATION);
            returnToOriginal();


        }else {
            showAlert("Alert", "Can't submit request, please fill all fields", Alert.AlertType.ERROR);
            returnToOriginal();
        }

    }

}
