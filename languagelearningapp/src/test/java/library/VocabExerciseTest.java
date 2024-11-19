package library;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.Question;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VocabExerciseTest {

    private VocabExerciseTest vocabExercise;
    private String exerciseId;
    private String type;
    private String difficulty;
    private String content;
    private ArrayList<Question> questions;
    private ArrayList<String> vocabularyList;
    private ArrayList<String> definitions;

    public VocabExerciseTest(String exerciseId2, String type2, String difficulty2, String content2,
            ArrayList<Question> questions2, ArrayList<String> vocabularyList2, ArrayList<String> definitions2) {
    }

    @BeforeEach
    public void setUp() {
        exerciseId = "vocab001";
        type = "Vocabulary";
        difficulty = "Easy";
        content = "Match the words with their meanings";
        questions = new ArrayList<>();

        vocabularyList = new ArrayList<>();
        vocabularyList.add("Loquacious");
        vocabularyList.add("Ephemeral");

        definitions = new ArrayList<>();
        definitions.add("Talkative");
        definitions.add("Short-lived");

        vocabExercise = new VocabExerciseTest(exerciseId, type, difficulty, content, questions, vocabularyList, definitions);
    }

    @Test
    public void testDisplayVocabulary() {
        System.out.println("Displaying vocabulary and definitions:");
        vocabExercise.testDisplayVocabulary();
        System.out.println("Vocabulary displayed successfully.");
    }

    @Test
    public void testGetVocabularyList() {
        assertEquals(vocabularyList, vocabExercise.GetVocabularyList());
        System.out.println("Vocabulary list retrieved and validated.");
    }

    private Object GetVocabularyList() {
        return null;
    }

    @Test
    public void testSetVocabularyList() {
        ArrayList<String> newVocabularyList = new ArrayList<>();
        newVocabularyList.add("Serendipity");
        vocabExercise.setVocabularyList(newVocabularyList);
        assertEquals(newVocabularyList, vocabExercise.GetVocabularyList());
        System.out.println("Vocabulary list set and validated.");
    }

    private Object tGetVocabularyList() {
        return null;
    }

    private void setVocabularyList(ArrayList<String> newVocabularyList) {
    }

    @Test
    public void testGetDefinitions() {
        assertEquals(definitions, vocabExercise.GetDefinitions());
        System.out.println("Definitions list retrieved and validated.");
    }

    private Object GetDefinitions() {
        return null;
    }

    @Test
    public void testSetDefinitions() {
        ArrayList<String> newDefinitions = new ArrayList<>();
        newDefinitions.add("Finding something good without looking for it");
        vocabExercise.setDefinitions(newDefinitions);
        assertEquals(newDefinitions, vocabExercise.GetDefinitions());
        System.out.println("Definitions list set and validated.");
    }

    private void setDefinitions(ArrayList<String> newDefinitions) {
    }

    @Test
    public void testExerciseAttributes() {
        
    }
}
