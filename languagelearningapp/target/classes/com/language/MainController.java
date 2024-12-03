package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Course;
import com.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

    @FXML
    private Label lbl_module1;
    @FXML
    private Label lbl_module2;
    @FXML
    private Label lbl_module3;
    @FXML
    private Label lbl_ranking;

    @FXML
    private void startModule1(MouseEvent event) throws IOException {
        Course.startLesson("Module 1");
        com.language.App.setRoot("module1_lesson");
    }

    @FXML
    private void startModule2(MouseEvent event) throws IOException {
        Course.startLesson("Module 2");
        com.language.App.setRoot("module2_lesson");
    }

    @FXML
    private void startModule3(MouseEvent event) throws IOException {
        Course.startLesson("Module 3");
        com.language.App.setRoot("module3_lesson");
    }

    @FXML
    private void viewRankings(MouseEvent event) throws IOException {
        String rankings = Course.getRankings();
        lbl_ranking.setText(rankings);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_ranking.setText("Click on a module to start. Rankings will be displayed after completion.");
    }
}
