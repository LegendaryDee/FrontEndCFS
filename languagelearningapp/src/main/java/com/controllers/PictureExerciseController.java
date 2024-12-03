package com.controllers;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PictureExerciseController {
    @FXML
    private ImageView exerciseImage;

    @FXML
    private TextField answerField;

    @FXML
    private Label feedbackLabel;

    private Map<Image, String> exercises;
    private Image currentImage;
    private int currentIndex;

    @FXML
    public void initialize() {
        // Initialize exercises
        exercises = new HashMap<>();
        exercises.put(new Image("languagelearningapp/images/greet.png"), "Manzana"); // "Apple"
        exercises.put(new Image("languagelearningapp/images/hbday.png"), "Casa"); // "House"
        exercises.put(new Image("languagelearningapp/images/pants.png"), "Libro"); // "Book"

        currentIndex = 0;
        loadExercise();
    }

    @FXML
    private void checkAnswer(ActionEvent event) {
        String userAnswer = answerField.getText().trim();
        String correctAnswer = exercises.get(currentImage);

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            feedbackLabel.setText("Correct!");
            feedbackLabel.setStyle("-fx-text-fill: green;");
        } else {
            feedbackLabel.setText("Incorrect. Try again.");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void nextExercise(ActionEvent event) {
        currentIndex = (currentIndex + 1) % exercises.size();
        loadExercise();
        answerField.clear();
        feedbackLabel.setText("");
    }

    private void loadExercise() {
        currentImage = (Image) exercises.keySet().toArray()[currentIndex];
        exerciseImage.setImage(currentImage);
    }
}
