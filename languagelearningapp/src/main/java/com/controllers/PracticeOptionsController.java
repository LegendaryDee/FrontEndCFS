package com.controllers;

import java.io.IOException;

import com.language.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class PracticeOptionsController {
     @FXML
    private void goToFlashcards(ActionEvent event) throws IOException {
        com.language.App.setRoot("Flashcards");
    }

    @FXML
    private void goToPictureExercises(ActionEvent event) throws IOException {
        com.language.App.setRoot("picture_exercises");
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }

    @FXML
    private void openDictionary(ActionEvent event) {
        String url = "https://www.spanishdict.com/";
        if (!openWebPage(url)) {
            showAlert("Error", "Unable to open the dictionary link.");
        }
    }

    private boolean openWebPage(String url) {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url).start();
            } else if (os.contains("mac")) {
                // macOS
                new ProcessBuilder("open", url).start();
            } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                // Unix/Linux
                new ProcessBuilder("xdg-open", url).start();
            } else {
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
