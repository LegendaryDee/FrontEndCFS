package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.UUID;

public class FeedbackTest {

    private FeedbackTest feedback;
    private UUID userUUID;
    private String feedbackText;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting FeedbackTest...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Finished FeedbackTest.");
    }

    @Before
    public void setUp() {
        userUUID = UUID.randomUUID();
        feedback = new FeedbackTest();
        feedback.userUUID = userUUID;
        feedback.feedbackText = "This is a sample feedback.";
    }

    @After
    public void tearDown() {
        feedback = null;
    }

    @Test
    public void testProvideFeedback() {
        feedback.testProvideFeedback();
        // Assuming provideFeedback has some functionality, add assertions here as necessary
        assertNotNull(feedback);
    }

    @Test
    public void testUserUUID() {
        assertEquals(userUUID, feedback.userUUID);
    }

    @Test
    public void testFeedbackText() {
        assertEquals("This is a sample feedback.", feedback.feedbackText);
    }
}
