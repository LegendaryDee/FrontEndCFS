package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
// import library.App;

public class UserHomeController implements Initializable {
    @FXML private Label lbl_title;
    @FXML private GridPane grid_books;
    private Library library;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String username = Library.getInstance().getUsername();
        if(username == null) {
            lbl_title.setText("Welcome Guest");
        }else{
        lbl_title.setText("Welcome " + username);
    }
}
    @FXML
    private void logout(MouseEvent event) throws IOException {
        com.language.App.setRoot("login");
    }

    @FXML
    private void courses(MouseEvent event) throws IOException {
        com.language.App.setRoot("courses");
    }

    @FXML
    private void progressdata(MouseEvent event) throws IOException {
        com.language.App.setRoot("progress_data");
    }

    @FXML
    private void practiceoptions(MouseEvent event) throws IOException {
        com.language.App.setRoot("practice_options");
    }

    @FXML
    private void addcourses(MouseEvent event) throws IOException {
        com.language.App.setRoot("add_courses");
    }

    @FXML
    private void settingsandprofile(MouseEvent event) throws IOException {
        com.language.App.setRoot("settings_and_profile");
    }

    @FXML
    private void notifications(MouseEvent event) throws IOException {
        com.language.App.setRoot("notifications");
    }
}
