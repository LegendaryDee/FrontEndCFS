/**
 * @author Demetrius Mack
 */
package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Module2Controller implements Initializable {

    @FXML
    private Label lbl_lessonContent;

    @FXML
    private void startQuiz(MouseEvent event) throws IOException {
        com.language.App.setRoot("module2_quiz");
    }

    @FXML
    private void backToMain(MouseEvent event) throws IOException {
        com.language.App.setRoot("MainController");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_lessonContent.setText(
                "Welcome to Module 2: Grammar!\n\nIn this lesson, you will learn:\n"
                + "- Sentence structure in Spanish\n"
                + "- Common verb conjugations (e.g., ser, estar, tener)\n"
                + "- Basic pronouns (yo, tú, él, ella, etc.)\n\n"
                + "Click on 'Start Quiz' when you're ready to test your knowledge!"
        );
    }
}
