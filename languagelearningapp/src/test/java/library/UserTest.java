package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.LanguagePreference;
import com.model.ProgressData;
import com.model.User;

import java.util.UUID;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(
                UUID.randomUUID(),
                "testUser",
                "password123",
                "test@example.com",
                LanguagePreference.ENGLISH, // Use enum value directly
                new ProgressData(UUID.randomUUID().toString()),
                5);
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(user.login("testUser", "password123"), "Login should succeed with correct username and password.");
    }

    @Test
    public void testLoginFailure() {
        assertFalse(user.login("testUser", "wrongPassword"), "Login should fail with incorrect password.");
    }

    @Test
    public void testUpdateProfile() {
        user.updateProfile(
                "updatedUser",
                "updated@example.com",
                LanguagePreference.SPANISH, // Use enum value directly
                10,
                new ProgressData(UUID.randomUUID().toString()));

        assertEquals("updatedUser", user.getUserName(), "Username should be updated.");
        assertEquals("updated@example.com", user.getEmail(), "Email should be updated.");
        assertEquals(LanguagePreference.SPANISH, user.getLanguagePreference(),
                "Language preference should be updated.");
        assertEquals(10, user.getStreakCount(), "Streak count should be updated.");
    }

    @Test
    public void testAddScore() {
        user.addScore(100);
        user.addScore(50);

        assertEquals(150, user.getTotalScore(), "Total score should be the sum of all scores.");
    }


    @Test
    public void testRecoverPassword() {
        assertDoesNotThrow(() -> user.recoverPassword(), "recoverPassword should not throw an exception.");
    }

    @Test
    public void testSubmitFeedback() {
        assertDoesNotThrow(() -> user.submitFeedback("Great app!"), "submitFeedBack should not throw an exception.");
    }
}