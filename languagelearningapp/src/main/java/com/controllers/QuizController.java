/**
 * @author Demetrius Mack
 */
package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizController {

    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private RadioButton option4;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    private Label scoreLabel;

    private final ToggleGroup optionsGroup = new ToggleGroup();

    private int currentQuestionIndex = 0;
    private int score = 0;
    private final List<String> results = new ArrayList<>();

    private final String[][] questions = {
            {"What is 'hello' in Spanish?", "Hola", "Adiós", "Gracias", "Por favor", "Hola"},
            {"What is 'thank you' in Spanish?", "Gracias", "Perdón", "Lo siento", "Adiós", "Gracias"},
            {"What is 'please' in Spanish?", "Hola", "Por favor", "Gracias", "Lo siento", "Por favor"},
            {"What is 'goodbye' in Spanish?", "Hola", "Adiós", "Gracias", "Perdón", "Adiós"},
            {"What is 'excuse me' in Spanish?", "Perdón", "Hola", "Adiós", "Lo siento", "Perdón"}
    };

    @FXML
    public void initialize() {
        // Group radio buttons
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            String[] currentQuestion = questions[currentQuestionIndex];
            questionLabel.setText(currentQuestion[0]);
            option1.setText(currentQuestion[1]);
            option2.setText(currentQuestion[2]);
            option3.setText(currentQuestion[3]);
            option4.setText(currentQuestion[4]);
            optionsGroup.selectToggle(null); // Clear previous selection
        } else {
            endQuiz();
        }
    }

    @FXML
    private void handleSubmit() {
        RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
        if (selectedOption != null) {
            String selectedAnswer = selectedOption.getText();
            String correctAnswer = questions[currentQuestionIndex][5];
            if (selectedAnswer.equals(correctAnswer)) {
                score++;
                results.add("Q" + (currentQuestionIndex + 1) + ": Correct");
            } else {
                results.add("Q" + (currentQuestionIndex + 1) + ": Incorrect (Your Answer: " + selectedAnswer + ")");
            }
            currentQuestionIndex++;
            loadQuestion();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an answer before submitting.");
            alert.showAndWait();
        }
    }

    private void endQuiz() {
        int totalQuestions = questions.length;
        double percentage = (score / (double) totalQuestions) * 100;

        StringBuilder resultSummary = new StringBuilder();
        for (String result : results) {
            resultSummary.append(result).append("\n");
        }

        questionLabel.setText("Quiz Completed!");
        option1.setDisable(true);
        option2.setDisable(true);
        option3.setDisable(true);
        option4.setDisable(true);
        submitButton.setDisable(true);
        scoreLabel.setText(String.format("Your score: %d / %d (%.2f%%)", score, totalQuestions, percentage));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Results");
        alert.setHeaderText("Quiz Results");
        alert.setContentText(resultSummary.toString());
        alert.showAndWait();
    }

    @FXML
    private void handleBackButton() throws IOException {
        com.language.App.setRoot("main"); // Go back to the MainController
    }
}
