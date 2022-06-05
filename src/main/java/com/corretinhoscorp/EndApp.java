package com.corretinhoscorp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EndApp extends Application {
    private static Scene endscene1;
    private static Scene endscene2;

    @Override
    public void start(Stage stage) throws IOException {
        endscene1 = new Scene(loadFXML("secondary"), 300, 300);
        endscene2 = new Scene(loadFXML("endscreen"), 200, 200);
        stage.setScene(endscene1);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException{
        endscene1.setRoot(loadFXML(fxml));
    }

    static Scene getScene1(){
        return endscene2;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EndApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();       
    }
}
