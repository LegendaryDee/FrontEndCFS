package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class questionThreeController {

    @FXML
    private AnchorPane rootPane; // Root pane to swap scenes

    @FXML
    private Button buttonUno;

    @FXML
    private Button buttonTres;

    @FXML
    private Button buttonDiez;

    private String correctAnswer; // Holds the correct answer for the current question

    public void initialize() {
        // Set the correct answer for this question
        correctAnswer = "Tres"; // Adjust this for each FXML
    }

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();

        // Check if the clicked button is correct
        if (clickedButton.getText().equals(correctAnswer)) {
            com.language.App.setRoot("numberFour");
        } else {
            // Turn the button red if incorrect
            clickedButton.setStyle("-fx-background-color: red;");
        }
    }
}
