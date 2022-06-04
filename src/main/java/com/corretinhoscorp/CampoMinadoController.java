package com.corretinhoscorp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CampoMinadoController {
    @FXML
    private GridPane Game;
    
    public CampoMinadoController() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Game.add(new Label("label"), i, j);
            }
        }
    }
}
