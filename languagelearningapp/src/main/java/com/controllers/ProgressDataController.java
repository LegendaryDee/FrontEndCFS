package com.controllers;

import java.io.IOException;

import com.model.ProgressData;

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
    private void addScore(ActionEvent event) throws IOException {
        try {
            int score = Integer.parseInt(txt_addScore.getText());
            progressData.addScore(score);
            loadProgressData();
        } catch (NumberFormatException e) {
            System.err.println("Invalid score input. Please enter a valid number.");
        }
    }

    @FXML
    private void saveProgress(ActionEvent event) throws IOException {
        progressData.saveProgress();
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }
}
