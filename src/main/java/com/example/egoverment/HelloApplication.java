package com.example.egoverment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Loginer.fxml"));
            Pane root = (Pane) loader.load();
            //Create a scene and set the stage
            System.out.println("in");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("");
            primaryStage.show();

            //Access the controller if needed
            //           Loginer_Controller controller = loader.getController();
            Loginer_Controller controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML. Check the file path.");
        }
    }

    //    public static void main(String[] args) {
    //        launch();
    //    }

    //    public void start(Stage primaryStage) throws Exception{
    //        Parent root = FXMLLoader.load(getClass().getResource("FinanceMinistry.fxml"));
    //        primaryStage.setTitle("E-government System");
    //        primaryStage.setScene(new Scene(root));
    //        primaryStage.show();
    //    }
    public static void main (String[] args){

        FileHelper.retrieveAll();
        launch(args);
        //        ArrayList<Ministry> ministries= new ArrayList<>();
        //        ministries=MinistriesCollection.getMinistries();
        //        int length = ministries.size()-1;
        //        for(int i=0;i<length;i++)
        //        {
        //            System.out.println(i + ministries.get(i).getMinistryName());
        //        }
        FileHelper.saveAll();

    }
}
