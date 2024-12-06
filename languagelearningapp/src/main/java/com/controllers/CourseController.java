package com.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.model.Course;
import com.model.CourseList;
import com.model.Language;
import com.model.Proficiency;

public class CourseController {
    @FXML
    private ListView<String> courseListView;

    @FXML
    private ObservableList<String> viewCourseButton;

    @FXML
    private Button removeCourseButton;

    @FXML
    private Button goToScreenButton; // New button for transitioning

    private CourseList courseList;

    @FXML
    public void initialize() {
       viewCourseButton = FXCollections.observableArrayList(
        "Spanish Course"
       );
       courseListView.setItems(viewCourseButton);
    }

    @FXML
    private void dismissSelectedCourse() {
        String selectedCourse = courseListView.getSelectionModel().getSelectedItem();
        if (selectedCourse == null) {
            showAlert("No selection", "Please select a course to dismiss.");
        } else {
            viewCourseButton.clear();
            showAlert("Success", "Course dismissed.");
        }
    }

    @FXML
    private void transitionToCourse(ActionEvent event) throws IOException {
        String selectedCourse = courseListView.getSelectionModel().getSelectedItem();
        if (selectedCourse == null) {
            showAlert("No Selection", "Please select a course to transition.");
        } else {
            com.language.App.setRoot("MainController"); // Replace with the actual FXML file for the target screen
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
