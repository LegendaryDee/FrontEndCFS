/**
 * @author Demetrius Mack 
 */

package com.controllers;

import com.model.Flashcards;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class FlashcardsController {

    // UI Components
    @FXML
    private Label wordLabel;

    @FXML
    private Label translationLabel;

    @FXML
    private Label phraseLabel;

    @FXML
    private Button nextButton;

    @FXML
    private Button prevButton;

    // List of flashcards
    private List<Flashcards> flashcards;

    // Current flashcard index
    private int currentIndex = 0;

    /**
     * Initializes the controller.
     * Sets up flashcards and displays the first one.
     */
    @FXML
    public void initialize() {
        // Create example flashcards (replace with dynamic data if necessary)
        flashcards = new ArrayList<>();
        flashcards.add(new Flashcards("Bonjour", "Hello", "Bonjour! Je m'appelle Pierre."));
        flashcards.add(new Flashcards("Hola", "Hello", "Hola! Me llamo Juan."));
        flashcards.add(new Flashcards("Guten Tag", "Good day", "Guten Tag! Wie geht's?"));
        flashcards.add(new Flashcards("Ciao", "Hello", "Ciao! Mi chiamo Marco."));

        // Display the first flashcard
        displayFlashcard();
    }

    /**
     * Displays the current flashcard on the screen.
     */
    private void displayFlashcard() {
        if (flashcards.isEmpty()) {
            wordLabel.setText("No flashcards available.");
            translationLabel.setText("");
            phraseLabel.setText("");
            return;
        }

        Flashcards currentFlashcard = flashcards.get(currentIndex);
        wordLabel.setText(currentFlashcard.getWord());
        translationLabel.setText(currentFlashcard.getTranslation());
        phraseLabel.setText(currentFlashcard.getPhrase());
    }

    /**
     * Event handler for the "Next" button.
     * Moves to the next flashcard if available.
     */
    @FXML
    private void onNextButtonClick() {
        if (currentIndex < flashcards.size() - 1) {
            currentIndex++;
            displayFlashcard();
        } else {
            System.out.println("You're already at the last flashcard.");
        }
    }

    /**
     * Event handler for the "Previous" button.
     * Moves to the previous flashcard if available.
     */
    @FXML
    private void onPrevButtonClick() {
        if (currentIndex > 0) {
            currentIndex--;
            displayFlashcard();
        } else {
            System.out.println("You're already at the first flashcard.");
        }
    }
}
