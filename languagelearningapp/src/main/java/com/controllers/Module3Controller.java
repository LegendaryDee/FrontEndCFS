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

public class Module3Controller implements Initializable {

    @FXML
    private Label lbl_lessonContent;

    @FXML
    private void startQuiz(MouseEvent event) throws IOException {
        com.language.App.setRoot("module3_quiz");
    }

    @FXML
    private void backToMain(MouseEvent event) throws IOException {
        com.language.App.setRoot("main");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_lessonContent.setText(
                "Welcome to Module 3: Vocabulary!\n\nIn this lesson, you will learn:\n"
                + "- Common everyday words (food, colors, family, etc.)\n"
                + "- Basic adjectives and how to use them\n"
                + "- Expanding your vocabulary to have simple conversations\n\n"
                + "Click on 'Start Quiz' when you're ready to test your knowledge!"
        );
    }
}
