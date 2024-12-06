package com.controllers;

import java.io.IOException;

import com.narration.Narrator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PictureExerciseController {
    @FXML
    private TextField txtObjectInSpanish; // Answer for "Spell the object in Spanish"
    @FXML
    private TextField txtEventDescription; // Answer for "What event is taking place"
    @FXML
    private TextField txtGreetingInEnglish; // Answer for "Spell the greeting in English"
    @FXML
    private Label lblFeedback; // To display feedback and grade
    @FXML
    private Button btnSubmit; // Submit button
    @FXML
    private Button btnReset; // Reset button
    @FXML
    private Button btnBack;

    // Correct answers (example values)
    private final String correctObjectInSpanish = "pantalones"; // Example: apple in Spanish
    private final String correctEventDescription = "birthday"; // Example: birthday event
    private final String correctGreetingInEnglish = "what's happening"; // Example: greeting in English

    public void initialize() {
        lblFeedback.setText(""); // Clear feedback initially
    }

    @FXML
    private void onSubmitClicked(MouseEvent event) {
        // Get user input
        String objectInSpanish = txtObjectInSpanish.getText().trim().toLowerCase();
        String eventDescription = txtEventDescription.getText().trim().toLowerCase();
        String greetingInEnglish = txtGreetingInEnglish.getText().trim().toLowerCase();

        // Initialize score
        int score = 0;

        // Validate answers
        if (objectInSpanish.equals(correctObjectInSpanish)) {
            score++;
        } else {
            Narrator.playSound("Hint for Question 1: It's something you wear on your legs.\n");
        }
        if (eventDescription.equals(correctEventDescription)) {
            score++;
        } else {
            Narrator.playSound("Hint for Question 2: It's a celebration of someone's birth.\n");
        }
        if (greetingInEnglish.equals(correctGreetingInEnglish)) {
            score++;
        } else {
            Narrator.playSound("Hint for Question 3: It's a casual way to ask someone what's going on.\n");
        }

        // Display grade and feedback
        lblFeedback.setText("Your score: " + score + "/3\n" + generateFeedback(score));
    }

    @FXML
    private void onResetClicked(MouseEvent event) {
        // Clear input fields and feedback
        txtObjectInSpanish.clear();
        txtEventDescription.clear();
        txtGreetingInEnglish.clear();
        lblFeedback.setText("");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("practice_options");
    }

    // Helper method to generate feedback based on score
    private String generateFeedback(int score) {
        switch (score) {
            case 3:
                return "Excellent! You got everything correct!";
            case 2:
                return "Good job! You got 2 out of 3.";
            case 1:
                return "Keep trying! You got 1 out of 3.";
            default:
                return "Better luck next time! Try again.";
    }
}
}
