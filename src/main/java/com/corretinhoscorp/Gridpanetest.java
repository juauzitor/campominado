package com.corretinhoscorp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Random;

public class Gridpanetest extends Application{
    private static Scene endscene2;
    private int cont, contbombs;
    int matx=10;
    int quantmaxbomba = matx*matx/3;
    
    Random r = new Random();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GridPane Experiment");
        endscene2 = new Scene(loadFXML("endscreen"), 200, 200);
        TitleButton buttons[][] = new TitleButton[matx][matx];
        GridPane gridPane = new GridPane();

        for (int i = 0; i < matx; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
            for (int j = 0; j < matx; j++) {
                //System.out.println(quantmaxbomba);
                if( quantmaxbomba > 0){ 
                    buttons[i][j] = new TitleButton(r.nextBoolean());
                    if (buttons[i][j].isBomb()) {
                        quantmaxbomba--;
                    }
                }
                else{
                    buttons[i][j] = new TitleButton(false);
                }
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
                        if(buttons[c][d].isBomb() == true){
                            buttons[c][d].setText("B");
                            //System.out.println("Tem: "+ ++contbombs);
                            //Stage stage = (Stage) buttons[c][d].getScene().getWindow();
                            //stage.setScene(Gridpanetest.getScene1());
                        }
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

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Gridpanetest.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static Scene getScene1(){
        return endscene2;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
