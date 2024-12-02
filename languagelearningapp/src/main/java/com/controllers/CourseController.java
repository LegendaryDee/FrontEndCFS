package com.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.model.Course;
import com.model.CourseList;

public class CourseController {
    @FXML
    private ListView<String> courseListView;

    @FXML
    private Button viewCourseButton;

    @FXML
    private Button removeCourseButton;

    private CourseList courseList;

    @FXML
    public void initialize() {
        refreshCourseList();

        // Enable buttons when a course is selected
        courseListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            boolean courseSelected = newVal != null;
            viewCourseButton.setDisable(!courseSelected);
            removeCourseButton.setDisable(!courseSelected);
        });
    }

    @FXML
    public void refreshCourseList() {
        List<Course> courses = CourseList.getInstance().getAllCourses();
        courseListView.getItems().setAll(courses.stream().map(Course::getTitle).collect(Collectors.toList()));
    }

    @FXML
    public void onRemoveCourseClicked() {
        String selectedTitle = courseListView.getSelectionModel().getSelectedItem();
        Course selectedCourse = findCourseByTitle(selectedTitle);
        if (selectedCourse != null) {
            CourseList.getInstance().removeCourse(selectedCourse.getId());
            showSuccess("Success", "Course removed successfully.");
            refreshCourseList(); // Manually refresh the list
        } else {
            showError("Error", "Selected course not found.");
        }
    }
                

    private Course findCourseByTitle(String title) {
        return CourseList.getInstance().getAllCourses().stream()
                .filter(course -> course.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    private void transitionToCourse(Course course) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Course Transition");
        alert.setHeaderText("Transitioning to Course");
        alert.setContentText("Course: " + course.getTitle() + "\nDescription: " + course.getDescription());
        alert.showAndWait();
        // Add your scene-switching logic here
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }

    private void showError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showSuccess(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
