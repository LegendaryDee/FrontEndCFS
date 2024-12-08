package com.controllers;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

public class ProgressDataController {

    @FXML
    private Label lbl_userID;

    @FXML
    private Label lbl_lessonsCompleted;

    @FXML
    private Label lbl_attempts;

    @FXML
    private Label lbl_totalScore;

    @FXML
    private ProgressBar progress_courseCompletion;

    @FXML
    private ListView<String> list_strugglingWords;

    @FXML
    private ListView<String> list_strugglingPhrases;

    public void initialize() {
        // Populate Struggling Words
        list_strugglingWords.setItems(FXCollections.observableArrayList(
            "Perdón" // Excuse me
        ));

        // Populate Struggling Phrases
        list_strugglingPhrases.setItems(FXCollections.observableArrayList(
            "El gato es negro",             // The cat is black
            "Tengo un libro",               // I have a book
            "Cenamos a las 7 PM",           // We eat dinner at 7 PM
            "¿Dónde está la estación de tren?", // Where is the train station?
            "A ella le gusta leer libros"   // She likes to read books
        ));

        // Populate other labels with placeholder data
        lbl_userID.setText("User ID: cdurant");
        lbl_lessonsCompleted.setText("Lessons Completed: 3");
        lbl_attempts.setText("Attempts: 3");
        lbl_totalScore.setText("Total Score: 14/20");

        // Set progress bar to one-fifth (20%) of the way
        progress_courseCompletion.setProgress(0.2);
    }

    @FXML
    private void saveProgress() {
        showAlert("Success", "Progress Saved", "Your progress has been successfully saved.", AlertType.INFORMATION);
    }

    private void showAlert(String title, String header, String content, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }
}
