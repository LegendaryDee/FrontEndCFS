package com.controllers;

import java.io.IOException;
import com.model.ProgressData;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProgressDataController {
    private ProgressData progressData;

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

    @FXML
    private TextField txt_addScore;

    public void setProgressData(ProgressData progressData) {
        this.progressData = progressData;
        loadProgressData();
    }

    private void loadProgressData() {
        lbl_userID.setText("User ID: " + progressData.getUserID());
        lbl_lessonsCompleted.setText("Lessons Completed: " + progressData.getLessonsCompleted());
        lbl_attempts.setText("Attempts: " + progressData.getAttempts());
        lbl_totalScore.setText("Total Score: " + progressData.getTotalScore());
        progress_courseCompletion.setProgress(progressData.getCourseCompletionPercentage() / 100.0);

        list_strugglingWords.getItems().setAll(progressData.getStrugglingWords());
        list_strugglingPhrases.getItems().setAll(progressData.getStrugglingPhrases());
    }

    @FXML
    private void saveProgress(ActionEvent event) throws IOException {
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
