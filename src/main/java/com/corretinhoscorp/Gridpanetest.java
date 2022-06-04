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

import java.util.Random;

public class Gridpanetest extends Application{
    private int cont;
    int matx=10;
    

    Random r = new Random();
    @Override
    public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("GridPane Experiment");
        
    TitleButton buttons[][] = new TitleButton[matx][matx];
    GridPane gridPane = new GridPane();

    for (int i = 0; i < matx; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
        for (int j = 0; j < matx; j++) {
            buttons[i][j] = new TitleButton(r.nextBoolean());
        }
    }

    for (int i = 0; i < buttons.length; i++) {
        for (int j = 0; j < buttons[i].length; j++) {
            int cont = 0;
            if (i > 0 && buttons[i-1][j].isBomb() == true) {
                cont++;
            }
            if(i < buttons.length-1 && buttons[i+1][j].isBomb() == true){
                cont++;
            }
            if(j > 0 && buttons[i][j-1].isBomb() == true){
                cont++;
            }
            if(j < buttons[i].length-1 && buttons[i][j+1].isBomb() == true){
                cont++;
            }
            if(i > 0 && j > 0 && buttons[i-1][j-1].isBomb() == true){
                cont++;
            }
            if(i > 0 && j < buttons[i].length-1 && buttons[i-1][j+1].isBomb() == true){
                cont++;
            }
            if(i < buttons.length-1 && j > 0 && buttons[i+1][j-1].isBomb() == true){
                cont++;
            }
            if(i < buttons.length-1 && j < buttons[i].length-1 && buttons[i+1][j+1].isBomb() == true){
                cont++;
            }
            buttons[i][j].setNearbyBombs(cont);
        }
    }

    for (int i = 0; i < matx; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
        for (int j = 0; j < matx; j++) {
            int b = cont;
            int c = i, d = j;
            buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    System.out.println("n = " + b);
                    System.out.println(buttons[c][d].getNearbyBombs());
                    if(buttons[c][d].isBomb() == true){buttons[c][d].setText("B");}
                    else{buttons[c][d].setText(Integer.toString(buttons[c][d].getNearbyBombs()));}
                }                
            });
            cont++;
        }
    }


    for (int i = 0; i < matx; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
        for (int j = 0; j < matx; j++) {
            gridPane.add(buttons[i][j], i, j);
        }
    }    
    Scene scene = new Scene(gridPane, 600, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
