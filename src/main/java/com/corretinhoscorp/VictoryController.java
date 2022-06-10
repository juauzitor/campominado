package com.corretinhoscorp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class VictoryController {
    @FXML private javafx.scene.control.Button victoryButton;
    
    @FXML
    private void victoryButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) victoryButton.getScene().getWindow(); //Instanciar a janela que o progama esta
        // do what you have to do
        stage.close(); // Fechar a janela
    }    
}