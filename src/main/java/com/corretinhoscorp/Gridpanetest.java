package com.corretinhoscorp;

import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;

public class Gridpanetest extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("GridPane Experiment");
    
    Button button1 = new Button("Button 1");
    Button button2 = new Button("Button 2");
    Button button3 = new Button("Button 3");
    Button button4 = new Button("Button 4");
    Button button5 = new Button("Button 5");
    Button button6 = new Button("Button 6");
    
    GridPane gridPane = new GridPane();

    for (int i = 0; i < 5; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
        for (int j = 0; j < 5; j++) {
            gridPane.add(new Button("Button" + i + j), i, j);
        }
    }    
    Scene scene = new Scene(gridPane, 240, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
