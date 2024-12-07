package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;

public class Owner_Menu_Controller {


        @FXML
        private Button manageMinistryButton;
        @FXML
        private Button addEmployeeButton;
        @FXML
        private Button removeEmployeeButton;
        @FXML
        private Button addFormButton;
        @FXML
        private Button removeFormButton;
        @FXML
        private Button logOutButton;
        @FXML
        private ImageView topImageView;

        // Action handler for 'Manage Ministry' button
        @FXML
        private void handleManageMinistryButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("AddMinistry.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }

        }

        // Action handler for 'Add Employee' button
        @FXML
        private void handleAddEmployeeButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("Add_Employee.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }

        }

        // Action handler for 'Remove Employee' button
        @FXML
        private void handleRemoveEmployeeButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("Remove_Employee.fxml");
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }
        }

        // Action handler for 'Add Form' button
        @FXML
        private void handlemanageFormButtonAction(ActionEvent event) {

            try {

                URL resource = getClass().getResource("AddForm.fxml");// put right one later
                if (resource == null) {
                    throw new IOException("FXML file not found: " );
                }

                Parent root = FXMLLoader.load(resource);

                Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                currentScene.setRoot(root);


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load FXML. Check the file path.");
            }

        }



    @FXML
    private void HandleLogout(ActionEvent event) {
        try {
            // Load the FXML for the primary stage images page
            Parent root = FXMLLoader.load(getClass().getResource("Loginer.fxml"));

            // Get the current stage from the event source
            Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
            currentScene.setRoot(root); // Switch the root
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }



}


