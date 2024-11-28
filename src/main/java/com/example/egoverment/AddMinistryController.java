package com.example.egoverment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

    public class AddMinistryController {

        @FXML
        private Pane AddListView;

        @FXML
        private Button AddMinistryButton;

        @FXML
        private ListView<String> AddMinistryListView;

        @FXML
        private TextField TextFieldAddMinistry;


        /////////////////////////////////////////////////for testing only///////////////////////////////////////////////
        private ObservableList<String>ministries= FXCollections.observableArrayList();
        @FXML
        public void initialize(){
            AddMinistryListView.setItems(ministries);
            AddMinistryButton.setOnAction(event->addMinistry());
        }
        private void addMinistry() {
            // Get the ministry name from the text field
            String ministryName = TextFieldAddMinistry.getText();

            // Add the ministry name to the list if not empty
            if (ministryName != null && !ministryName.trim().isEmpty()) {
                ministries.add(ministryName.trim());
                TextFieldAddMinistry.clear(); // Clear the text field
            } else {
                System.out.println("Ministry name cannot be empty.");
            }
        }
        public ObservableList<String> getMinistries() {
            return ministries;
        }
        public void dropMinistry(String ministryName) {
            ministries.remove(ministryName);
        }
        public void clearMinistries() {
            ministries.clear();
        }
    }


