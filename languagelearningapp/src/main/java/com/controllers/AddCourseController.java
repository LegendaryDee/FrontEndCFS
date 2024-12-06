package com.controllers;
import com.model.Course;
import com.model.Language;
import com.model.Proficiency;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
    public void initialize() {
        languageComboBox.getItems().addAll("Spanish", "French", "German");
        proficiencyComboBox.getItems().addAll("Novice", "Beginner", "Competent", "Proficient", "Expert");
    }

    @FXML
    private void onAddCourseClicked() {
        String language = languageComboBox.getValue();
        String difficulty = proficiencyComboBox.getValue();

        // Validate inputs
        if (language == null || difficulty == null) {
            showError("Invalid Input", "Please select both language and proficiency.");
            return;
        }

        // Default title and description
        String defaultTitle = language + " Course";
        String defaultDescription = "A " + difficulty + " level " + language + " course.";  // Default description

        // Create a new course with default title and description
        Course newCourse = new Course(UUID.randomUUID(), Language.valueOf(language.toUpperCase()), defaultTitle, null, defaultDescription, Proficiency.valueOf(difficulty.toUpperCase()));

        // Manually refresh the course list in the management screen
        CourseController courseController = getCourseController();
        if (courseController != null) {
            courseController.refreshCourseList();
        }

        showSuccess("Course Added", "The course '" + defaultTitle + "' has been added successfully.");
        clearFields();
    }

    private CourseController getCourseController() {
        // Implement logic to retrieve a reference to CourseController
        return null; // Replace with actual implementation
    }

    private void clearFields() {
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
