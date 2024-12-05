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

public class Module1Controller implements Initializable {

    @FXML
    private Label lbl_lessonContent;

    @FXML
    private void startQuiz(MouseEvent event) throws IOException {
        com.language.App.setRoot("module1_quiz");
    }

    @FXML
    private void backToMain(MouseEvent event) throws IOException {
        com.language.App.setRoot("main");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_lessonContent.setText(
                "Welcome to Module 1: Basics!\n\nIn this lesson, you will learn:\n"
                + "- How to greet in Spanish (Hola, Buenos días, etc.)\n"
                + "- Basic phrases like 'Cómo estás' (How are you?)\n"
                + "- Numbers from 1 to 10\n\n"
                + "Click on 'Start Quiz' when you're ready to test your knowledge!"
        );
    }
}
