package library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class DictionaryTest {

    private DictionaryTest dictionary;

    @BeforeEach
    public void setUp() {
        dictionary = new DictionaryTest();
        Map<String, String> translationMap = new HashMap<String, String>();
        // Manually add some entries to the dictionary
        translationMap.put("hello", "hola");
        translationMap.put("goodbye", "adiós");
        dictionary.setTranslations(translationMap);
    }

    private void setTranslations(Map<String, String> translationMap) {
    }

    @Test
    public void testLookupWordExists() {
        // Test lookup for a word that exists in the dictionary
        dictionary = new DictionaryTest();
        Map<String, String> translationMap = new HashMap<String, String>();
        // Manually add some entries to the dictionary
        translationMap.put("hello", "hola");
        translationMap.put("goodbye", "adiós");
        dictionary.setTranslations(translationMap);
    assertEquals("hola", dictionary.lookupWord("hello"), "Expected 'hello' to translate to 'hola'");
        assertEquals("adiós", dictionary.lookupWord("goodbye"), "Expected 'goodbye' to translate to 'adiós'");
    }

    private Object lookupWord(String string) {
        return null;
    }

    @Test
    public void testLookupWordDoesNotExist() {
        dictionary = new DictionaryTest();
        // Test lookup for a word that does not exist in the dictionary
        assertNull(dictionary.lookupWord("unknown"), "Expected translation for an unknown word to be null");
    }

    @Test
    public void testLookupNullInput() {
        // Test lookup with null input
        dictionary = new DictionaryTest();
        assertNull(dictionary.lookupWord(null), "Expected translation for null input to be null");
    }
}
