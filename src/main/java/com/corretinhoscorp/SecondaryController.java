package com.corretinhoscorp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML private javafx.scene.control.Button secondaryButton;

    @FXML
    private void switchToPrimary() throws IOException {
        //App.setRoot("endscreen");
        Stage stage = (Stage) secondaryButton.getScene().getWindow();
        stage.setScene(EndApp.getScene1());
    }
}