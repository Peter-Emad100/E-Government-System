package com.example.egoverment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class User_Menu_Controller {
    @FXML
    private FlowPane flowPane;
    public static String ministryName_controller;


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

    public void initialize() {
        // Clear any existing content
        flowPane.getChildren().clear();

        for (Ministry ministry : MinistriesCollection.getMinistries()) {

            String ministryName = ministry.getMinistryName();
            Button ministryButton = new Button(ministryName);


            ministryButton.setPrefSize(200, 100);
            ministryButton.setStyle("-fx-font-size: 14px; -fx-background-color: #4682B4; -fx-text-fill: white;");



            // on action for each ministry buttons

            if(ministryName.equals("Ministry of Education")) {
                ministryButton.setOnAction(event -> {

                    try {

                        URL resource = getClass().getResource("Education.fxml");
                        if (resource == null) {
                            throw new IOException("FXML file not found: " );
                        }
                        ministryName_controller = ministryName;

                        Parent root = FXMLLoader.load(resource);

                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root);


                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });

                }
            else if(ministryName.equals("Ministry of Finance")) {
                ministryButton.setOnAction(event -> {

                    try {

                        URL resource = getClass().getResource("FinanceMinistry.fxml");
                        if (resource == null) {
                            throw new IOException("FXML file not found: " );
                        }
                        ministryName_controller = ministryName;

                        Parent root = FXMLLoader.load(resource);

                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root);


                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });

            }
            else if(ministryName.equals("Ministry of Transportation")) {
                ministryButton.setOnAction(event -> {

                    try {

                        URL resource = getClass().getResource("Transportation.fxml");
                        if (resource == null) {
                            throw new IOException("FXML file not found: " );
                        }
                        ministryName_controller = ministryName;

                        Parent root = FXMLLoader.load(resource);

                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root);


                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });

            }
            else
            if(ministryName.equals("Ministry Electricity and Energy")) {
                ministryButton.setOnAction(event -> {

                    try {

                        URL resource = getClass().getResource("MinistryOfElectricity.fxml");
                        if (resource == null) {
                            throw new IOException("FXML file not found: " );
                        }
                        ministryName_controller = ministryName;

                        Parent root = FXMLLoader.load(resource);

                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root);


                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });

            }
            else if(ministryName.equals("Ministry of Health and population")) {
                ministryButton.setOnAction(event -> {

                    try {

                        URL resource = getClass().getResource("MinistryOfHealthAndPopulation.fxml");
                        if (resource == null) {
                            throw new IOException("FXML file not found: " );
                        }
                        ministryName_controller = ministryName;

                        Parent root = FXMLLoader.load(resource);

                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root);


                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });

            }
            else if(ministryName.equals("Ministry Of Tourism")) {
                ministryButton.setOnAction(event -> {

                    try {

                        URL resource = getClass().getResource("Tourism.fxml");
                        if (resource == null) {
                            throw new IOException("FXML file not found: " );
                        }
                        ministryName_controller = ministryName;

                        Parent root = FXMLLoader.load(resource);

                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root);


                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });

            }
            else { // else load to its department page straight away(new ministries will be treated this way)
                ministryButton.setOnAction(event -> {

                    try {
                        ministryName_controller = ministryName;
                        Parent root = FXMLLoader.load(getClass().getResource("showDepartments.fxml"));

                        // Get the current stage from the event source
                        Scene currentScene = ((Scene) ((javafx.scene.Node) event.getSource()).getScene());
                        currentScene.setRoot(root); // Switch the root

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to load FXML. Check the file path.");
                    }
                });
            }
                // Add the button to the FlowPane
                flowPane.getChildren().add(ministryButton);

            }


    }
}
