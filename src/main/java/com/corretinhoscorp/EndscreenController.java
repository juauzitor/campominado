package com.corretinhoscorp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EndscreenController {
    @FXML private javafx.scene.control.Button closeButton;
    
    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow(); //Instanciar a janela que o progama esta
        // do what you have to do
        stage.close(); // Fechar a janela
    }    
}