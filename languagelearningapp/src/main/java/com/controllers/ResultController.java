package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class ResultController {

    @FXML
    private Button retryButton;

    @FXML
    private Button continueButton;

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();

        // Determine the target scene based on the button's text
        if (clickedButton.getText().equals("Retry")) {
            com.language.App.setRoot("numberOne");
        } else if (clickedButton.getText().equals("Continue")) {
            com.language.App.setRoot("MainController");
        }
    }
}
