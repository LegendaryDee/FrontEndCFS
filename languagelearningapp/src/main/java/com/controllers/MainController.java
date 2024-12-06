package com.controllers;

import com.model.Course;
import com.model.Language;
import com.model.Lesson;
import com.model.Proficiency;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainController {

    @FXML
    private TableView<Course> modulesTable;

    @FXML
    private TableColumn<Course, String> moduleColumn;

    @FXML
    private TableColumn<Course, String> descriptionColumn;

    @FXML
    private TableColumn<Course, String> actionColumn;

    public void initialize() {
        moduleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));

        // Using a valid Language enum constant
        Language language = Language.SPANISH; // Set the language to Spanish as an example

        // Creating lessons with UUID, title, and description
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(UUID.randomUUID(), "Lesson 1", "Intro to Spanish"));
        lessons.add(new Lesson(UUID.randomUUID(), "Lesson 2", "Basic Vocabulary"));
        lessons.add(new Lesson(UUID.randomUUID(), "Lesson 3", "Numbers Quiz"));

        // Example courses data
        Course course1 = new Course(UUID.randomUUID(), language, "Spanish for Beginners", lessons, "Introduction to basic Spanish phrases.", Proficiency.BEGINNER);
        Course course2 = new Course(UUID.randomUUID(), language, "Intermediate Spanish", lessons, "Learn more advanced Spanish grammar.", Proficiency.NOVICE);
        Course course3 = new Course(UUID.randomUUID(), language, "Basic Numbers in Spanish", lessons, "Learn the numbers 1-10 in Spanish", Proficiency.BEGINNER);

        // Add these courses to the TableView
        modulesTable.getItems().add(course1);
        modulesTable.getItems().add(course2);
        modulesTable.getItems().add(course3);

        // Adding a row click event handler
        modulesTable.setRowFactory(tv -> {
            TableRow<Course> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Course course = row.getItem();
                    startLesson(course);
                }
            });
            return row;
        });
    }

    private void startLesson(Course course) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Start Lesson");
        alert.setHeaderText("Starting Lesson for: " + course.getTitle());
        alert.setContentText("You are about to start the lesson: " + course.getDescription());
        alert.showAndWait();

        // If the course is "Basic Numbers in Spanish", load the numbers quiz screen
        if (course.getTitle().equals("Basic Numbers in Spanish")) {
            try {
                com.language.App.setRoot("numberOne");  // Load the numberOne.fxml screen
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void exitApplication(MouseEvent event) throws IOException {
        com.language.App.setRoot("courses");
    }
}
