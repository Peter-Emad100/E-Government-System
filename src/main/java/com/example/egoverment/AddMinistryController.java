package com.example.egoverment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;




public class AddMinistryController {

    public Button removeMinistryButton;
    public Button BackButton;
    public Button editMinistryButton;
    @FXML
    private Pane AddListView;

    @FXML
    private Button AddMinistryButton;

    @FXML
    private ListView<String> AddMinistryListView;

    @FXML
    private TextField TextFieldAddMinistry;


    public void addMinistry() {
        String ministryName = TextFieldAddMinistry.getText();

        if (ministryName == null || ministryName.trim().isEmpty()) {
            String response = "Ministry name cannot be empty.";
            showAlert(response);
            TextFieldAddMinistry.clear();
            return;
        }

        boolean isFound = false;
        for (Ministry ministry : MinistriesCollection.getMinistries()) {
            try{
                if (ministry.getMinistryName().equalsIgnoreCase(ministryName.trim())) {
                    isFound = true;
                    String response = "This ministry already exists.";
                    showAlert(response);
                    break; // Exit loop as duplicate is found
                }
            }
            catch(NullPointerException e){
                String response = "Ministry name cannot be empty.";
                showAlert(response);

            }
        }
        if (!isFound) {
            MinistriesCollection.add(ministryName);
            String response = "Ministry successfully added.";
            showAlert(response);
        }
        TextFieldAddMinistry.clear();
    }

    public void removeMinistry() {
        // Get the ministry name from the text field
        String ministryName = TextFieldAddMinistry.getText();

        // Validate input
        if (ministryName == null || ministryName.trim().isEmpty()) {
            String response = "Ministry name cannot be empty.";
            showAlert(response);
            TextFieldAddMinistry.clear();
            return;
        }

        boolean isFound = false;
        for (Ministry ministry : MinistriesCollection.getMinistries()) {
            // Check if ministry name matches
            if (ministry.getMinistryName().equalsIgnoreCase(ministryName.trim())) {
                isFound = true;
                MinistriesCollection.remove(ministry); // Pass the ministry object to remove
                String response2 = "Ministry successfully removed.";
                showAlert(response2);
                break;
            }
        }

        if (!isFound) {
            String response3 = "This ministry does not exist.";
            showAlert(response3);
        }

        TextFieldAddMinistry.clear();
    }


    public void editMinistry() {
        String ministryName = TextFieldAddMinistry.getText();
        String oldName = TextFieldAddMinistry.getText();

        if (ministryName == null || ministryName.trim().isEmpty()) {
            String response = "Ministry name cannot be empty.";
            showAlert(response);
            TextFieldAddMinistry.clear();
            return;
        }
        boolean isFound = false;
        for (Ministry ministry : MinistriesCollection.getMinistries()) {
            if (ministry.getMinistryName().equalsIgnoreCase(ministryName.trim())) {
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            String response = "This ministry does not exist.";
            showAlert(response);
            return;
        }

//         Input is valid, navigate to the next page
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editMinistry.fxml"));
            Parent root = loader.load();

            // Pass the oldName to the second page
            editMinistryController controller = loader.getController();
            controller.setOldMinistryName(oldName);

            Stage stage = (Stage) TextFieldAddMinistry.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Operation Status");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
