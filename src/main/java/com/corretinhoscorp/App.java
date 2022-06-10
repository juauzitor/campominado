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

public class App extends Application{
    private static Scene endscene2;
    private static Scene victory;
    private int cont, contbombs;
    int matx=10; // Tamanho da matriz, para linhas e coluna
    int quantmaxbomb = (int)(matx*matx*0.12); // % de bombas no campo minado
    int safeGround = matx*matx-quantmaxbomb; // quadrados sem bomba
    
    Random r = new Random(); // objeto que vai ser usado para embaralhar o campo
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GridPane Experiment");
        endscene2 = new Scene(loadFXML("endscreen"), 200, 200); //tela de fim de jogo
        victory = new Scene(loadFXML("victory"), 200, 200); // tela de vitória
        GroundButton buttons[][] = new GroundButton[matx][matx]; // Vetor de GrondPane
        GridPane gridPane = new GridPane(); // objeto do tipo gridpane que é o container onde são guardados os botões

        for (int i = 0; i < matx; i++) { // O gridPane adiciona automaticamente novas linhas e colunas então um for reolve o problema da matriz
            for (int j = 0; j < matx; j++) {
                buttons[i][j] = new GroundButton(); // for responsavel por guardar os botões dentro do container
            }
        }

        generateBombs(buttons, quantmaxbomb, r, matx); //chamando função geradora de bombas

        for (int i = 0; i < matx; i++) { // função para configurar os botões
            for (int j = 0; j < matx; j++) {
                int b = cont;
                int c = i, d = j;
                calcNearBombs(buttons, c, j);
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        if(buttons[c][d].isBomb() == true){
                            buttons[c][d].setText("B"); // colocando no botão a letra b para quando o botao é bomba
                            System.out.println("Tem: "+ ++contbombs); // terminal mostrando quando tem bombas
                            Stage stage = (Stage) buttons[c][d].getScene().getWindow(); // Instanciar a janela que o progama esta
                            stage.setScene(App.getScene1()); // Define a cena com a tela de derrota
                        }
                        else{
                            buttons[c][d].setText(Integer.toString(buttons[c][d].getNearbyBombs())); // convertendo o numero de bombas para string para colocar em cada botao livre que tem bombas ao redor
                            if (--safeGround == 0){ // Diminuir em 1 a variavel safeGround e verificar se ela 
                                System.out.println("Victory");
                                Stage stage = (Stage) buttons[c][d].getScene().getWindow(); // Instanciar a janela que o progama esta
                                stage.setScene(App.getScene2()); // Define a cena com a tela de vitoria
                            }
                            seekSafeGround(buttons, c, d); //chamando a função que busca terrenos sem bombas, efeito recursivo em cadeia
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
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static Scene getScene1(){ // Retorna a tela de derrota
        return endscene2;
    }
    static Scene getScene2(){ // Retorna a tela de vitória
        return victory;
    }

    static void generateBombs(GroundButton buttons[][], int quantmaxbomb, Random r, int tam){ // função que gera os objetos de bomba 
        while (quantmaxbomb > 0) {
            int col, row;
            col = r.nextInt(tam);
            row = r.nextInt(tam); // so são colocadas bombas em terrenos que não possuem bombas proximas
            if (buttons[col][row].isBomb() == false) {
                buttons[col][row].setBomb();
                quantmaxbomb--;    
            }    
        }
    }

    public void calcNearBombs(GroundButton buttons[][], int c, int r) { // função que calcula a quantidade de bombas proximas na diagonais e lados do bloco
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

    
    public void seekSafeGround(GroundButton buttons[][], int c, int r){ // Funcão para buscar terrenos seguros
        System.out.println("rodando");
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(((c+i) >= 0 && (c+i) < buttons.length) && ((r+j) >= 0 && (r+j) < buttons[c].length)){ // If para evitar que exeção de ultrapassar limite do vetor 
                    if(buttons[c+i][r+j].getNearbyBombs() == 0 && !(buttons[c+i][r+j].isClicked())){ // If para pegar apenas terrenos com 0 bombas proximas e que nunca foram ativados
                        buttons[c+i][r+j].setClicked();
                        buttons[c+i][r+j].setText("0");
                        --safeGround;
                        seekSafeGround(buttons, c+i, r+j); // recursão
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
