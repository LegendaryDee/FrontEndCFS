/**
 * @author Demetrius Mack
 */
package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FillInTheBlankController {

    @FXML
    private Label questionLabel;

    @FXML
    private TextField answerField;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    private Label scoreLabel;

    private int currentQuestionIndex = 0;
    private int score = 0;
    private final List<String> results = new ArrayList<>();

    private final String[][] questions = {
            {"Translate to Spanish: 'The cat is black'", "El gato es negro"},
            {"Translate to Spanish: 'I have a book'", "Tengo un libro"},
            {"Translate to Spanish: 'We eat dinner at 7 PM'", "Cenamos a las 7 PM"},
            {"Translate to Spanish: 'Where is the train station?'", "¿Dónde está la estación de tren?"},
            {"Translate to Spanish: 'She likes to read books'", "A ella le gusta leer libros"}
    };

    @FXML
    public void initialize() {
        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex][0]);
            answerField.clear();
        } else {
            endAssessment();
        }
    }

    @FXML
    private void handleSubmit() {
        String userAnswer = answerField.getText().trim();
        if (!userAnswer.isEmpty()) {
            String correctAnswer = questions[currentQuestionIndex][1];
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                score++;
                results.add("Q" + (currentQuestionIndex + 1) + ": Correct");
            } else {
                results.add("Q" + (currentQuestionIndex + 1) + ": Incorrect (Your Answer: " + userAnswer + ")");
            }
            currentQuestionIndex++;
            loadQuestion();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter an answer before submitting.");
            alert.showAndWait();
        }
    }

    private void endAssessment() {
        int totalQuestions = questions.length;
        double percentage = (score / (double) totalQuestions) * 100;

        StringBuilder resultSummary = new StringBuilder();
        for (String result : results) {
            resultSummary.append(result).append("\n");
        }

        questionLabel.setText("Assessment Completed!");
        answerField.setDisable(true);
        submitButton.setDisable(true);
        scoreLabel.setText(String.format("Your score: %d / %d (%.2f%%)", score, totalQuestions, percentage));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Results");
        alert.setHeaderText("Assessment Results");
        alert.setContentText(resultSummary.toString());
        alert.showAndWait();
    }

    @FXML
    private void handleBackButton() throws IOException {
        com.language.App.setRoot("MainController"); // Go back to the MainController
    }
}
