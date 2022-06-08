package com.corretinhoscorp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.geometry.Insets; 
//import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene; 
//import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane; 
//import javafx.scene.text.Text; 
//import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Random;

public class Gridpanetest extends Application{
    //private static Scene endscene2;
    private static Scene victory;
    private int cont, contbombs;
    int matx=10;
    int quantmaxbomba = matx*matx/3;
    int safeGround = matx*matx-quantmaxbomba;
    
    Random r = new Random();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GridPane Experiment");
        //endscene2 = new Scene(loadFXML("endscreen"), 200, 200);
        victory = new Scene(loadFXML("victory"), 200, 200);
        GroundButton buttons[][] = new GroundButton[matx][matx];
        GridPane gridPane = new GridPane();

        for (int i = 0; i < matx; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
            for (int j = 0; j < matx; j++) {
                buttons[i][j] = new GroundButton();
            }
        }

        generateBombs(buttons, quantmaxbomba, r, matx);

        for (int i = 0; i < matx; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
            for (int j = 0; j < matx; j++) {
                int b = cont;
                int c = i, d = j;
                calcNearBombs(buttons, c, j);
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        if(buttons[c][d].isBomb() == true){
                            buttons[c][d].setText("B");
                            System.out.println("Tem: "+ ++contbombs);
                            //Stage stage = (Stage) buttons[c][d].getScene().getWindow();
                            //stage.setScene(Gridpanetest.getScene1());
                        }
                        else{
                            buttons[c][d].setText(Integer.toString(buttons[c][d].getNearbyBombs()));
                            if (--safeGround == 0){
                                System.out.println("Victory");
                            Stage stage = (Stage) buttons[c][d].getScene().getWindow();
                            stage.setScene(Gridpanetest.getScene2());
                            }
                            seekSafeGround(buttons, c, d);
                        }
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
/*
    static Scene getScene1(){
        return endscene2;
    }*/
    static Scene getScene2(){
        return victory;
    }

    static void generateBombs(GroundButton buttons[][], int quantmaxbomba, Random r, int tam){
        while (quantmaxbomba > 0) {
            int col, row;
            col = r.nextInt(tam);
            row = r.nextInt(tam);
            if (buttons[col][row].isBomb() == false) {
                buttons[col][row].setBomb();
                quantmaxbomba--;    
            }    
        }
    }

    public void calcNearBombs(GroundButton buttons[][], int c, int r) {
    	int cont = 0;
    	for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (((c+i) >= 0 && (c+i) < buttons.length) && ((r+j) >= 0 && (r+j) < buttons[c].length)){
                	if(buttons[c+i][r+j].isBomb()) {
                		cont++;
                	}
                }         
            }
        }
    	buttons[c][r].setNearbyBombs(cont);
    }

    
    public void seekSafeGround(GroundButton buttons[][], int c, int r){
        System.out.println("rodando");
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(((c+i) >= 0 && (c+i) < buttons.length) && ((r+j) >= 0 && (r+j) < buttons[c].length)){
                    if(buttons[c+i][r+j].getNearbyBombs() == 0 && !(buttons[c+i][r+j].isClicked())){
                        buttons[c+i][r+j].setClicked();
                        buttons[c+i][r+j].setText("0");
                        --safeGround;
                        seekSafeGround(buttons, c+i, r+j);
                    }
                }        
            }
        }
        return;
    }
      
    public static void main(String[] args) {
        Application.launch(args);
    }
}
