package com.example.egoverment;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PageSwitchHelper {
    public static <T>void switcher(String fxmFile,String title,Stage currentStage){
        try {
            FXMLLoader loader = new FXMLLoader(PageSwitchHelper.class.getResource(fxmFile));
            AnchorPane Page = loader.load();
            T Controller = loader.getController();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(Page));

            stage.show();
            if (currentStage != null) {
                currentStage.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
