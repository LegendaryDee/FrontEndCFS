package com.controllers;
import com.model.Course;
import com.model.Language;
import com.model.Proficiency;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.UUID;

public class AddCourseController {
    @FXML
    private ComboBox<String> languageComboBox;

    @FXML
    private ComboBox<String> proficiencyComboBox;

    @FXML
    private TextField courseTitleField;

    @FXML
    private TextField courseDescriptionField;

    @FXML
    public void initialize() {
        // Populate language options
        languageComboBox.getItems().addAll("Spanish", "French", "German");

        // Populate difficulty options
        proficiencyComboBox.getItems().addAll("Novice", "Beginner", "Competent", "Proficient", "Expert");
    }

    @FXML
    private void onAddCourseClicked() {
        String title = courseTitleField.getText();
        String description = courseDescriptionField.getText();
        String language = languageComboBox.getValue();
        String difficulty = proficiencyComboBox.getValue();

        // Validate inputs
        if (title.isEmpty() || description.isEmpty() || language == null || difficulty == null) {
            showError("Invalid Input", "Please fill in all fields before adding a course.");
            return;
        }

        // Create a new course
        Course newCourse = new Course(UUID.randomUUID(), Language.valueOf(language.toUpperCase()), title, null, description, Proficiency.valueOf(difficulty.toUpperCase()));
    

        // Manually refresh the course list in the management screen
        CourseController courseController = getCourseController();
        if (courseController != null) {
            courseController.refreshCourseList();
        }
    }

    private CourseController getCourseController() {
        // Implement logic to retrieve a reference to CourseManagementController
        // Example: Use a shared context or pass the reference via dependency injection
        return null; // Replace with actual implementation
    }

    private void clearFields() {
        courseTitleField.clear();
        courseDescriptionField.clear();
        languageComboBox.setValue(null);
        proficiencyComboBox.setValue(null);
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
