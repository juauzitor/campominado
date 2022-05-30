package com.corretinhoscorp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;

public class Gridpanetest extends Application{
    private int cont;
    @Override
    public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("GridPane Experiment");
        
    Button buttons[][] = new Button[5][5];
    GridPane gridPane = new GridPane();

    for (int i = 0; i < 5; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
        for (int j = 0; j < 5; j++) {
            int b = cont;
            buttons[i][j] = new Button("Button" + i +j);
            buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    System.out.println("n = " + b);
                }                
            });
            cont++;
        }
    }

    for (int i = 0; i < 5; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
        for (int j = 0; j < 5; j++) {
            gridPane.add(buttons[i][j], i, j);
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
