/**
 * @author Demetrius Mack 
 */
package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Course;
import com.model.Topic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

    @FXML
    private VBox moduleContainer; // VBox for dynamically adding module rows

    private List<Course> courses; // List of Course objects

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize courses with dummy data (replace with actual data retrieval if necessary)
        courses = new ArrayList<>();
        
        // Example data setup
        Course spanishBasics = new Course(
            UUID.randomUUID(), 
            "Spanish Basics", 
            "Learn essential Spanish vocabulary and phrases."
        );
        spanishBasics.addTopic(new Topic("Greetings", "Learn how to greet in Spanish."));
        spanishBasics.addTopic(new Topic("Numbers", "Learn to count in Spanish."));
        
        Course grammarEssentials = new Course(
            UUID.randomUUID(),
            "Grammar Essentials",
            "Master Spanish grammar fundamentals."
        );
        grammarEssentials.addTopic(new Topic("Verb Conjugation", "Learn how to conjugate common verbs."));
        
        Course everydayPhrases = new Course(
            UUID.randomUUID(),
            "Everyday Phrases",
            "Learn phrases for common situations."
        );
        everydayPhrases.addTopic(new Topic("Ordering Food", "Learn phrases for ordering food."));
        everydayPhrases.addTopic(new Topic("Asking for Directions", "Learn phrases for navigating."));
        
        courses.add(spanishBasics);
        courses.add(grammarEssentials);
        courses.add(everydayPhrases);

        // Populate the module rows in the UI
        loadModuleRows();
    }

    /**
     * Dynamically loads module rows into the VBox container.
     */
    private void loadModuleRows() {
        for (Course course : courses) {
            // Create an HBox for each module row
            HBox moduleRow = new HBox();
            moduleRow.setSpacing(20); // Spacing between elements
            moduleRow.setStyle("-fx-padding: 10; -fx-border-color: #ddd; -fx-border-width: 1;");

            // Label for the course title
            Label moduleLabel = new Label(course.getTitle());
            moduleLabel.setStyle("-fx-font-size: 16px; -fx-padding: 5;");

            // Start button
            Button startButton = new Button("Start");
            startButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 14px;");
            startButton.setOnMouseClicked(event -> startModule(course));

            // Add the label and button to the row
            moduleRow.getChildren().addAll(moduleLabel, startButton);

            // Add the row to the VBox container
            moduleContainer.getChildren().add(moduleRow);
        }
    }

    /**
     * Event handler for the "Start" button.
     * Starts the first lesson of the selected course.
     *
     * @param course the selected Course object
     */
    private void startModule(Course course) {
        try {
            if (course.getTopics().isEmpty()) {
                System.out.println("No lessons available for this course.");
                return;
            }
            System.out.println("Starting course: " + course.getTitle());
            course.startLesson(); // Start the first lesson
            com.language.App.setRoot("lesson_screen"); // Navigate to the lesson screen
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
