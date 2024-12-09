package com.example.egoverment;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

public class RequestController {
    String formName=showDepartmentsController.selectedForm;

    private int lengthofArrRequest;

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

        //make sure that texts aren't submitted null except for comments
        if(addressField.getText() != null && !addressField.getText().trim().isEmpty()
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
