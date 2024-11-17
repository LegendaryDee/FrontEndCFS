package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTests {

    @Test
    public void testTesting() {
        // Simple test to verify the test environment is working
        assertTrue(true);
    }

    @Test
    public void testLoginValid() {
        // Set up UserList and add a valid user
        UserList userList = UserList.getInstance();
        userList.addUser(new User(
            java.util.UUID.randomUUID(), 
            "jdoe", 
            "password123", 
            "jdoe@example.com", 
            LanguagePreference.ENGLISH, 
            new ProgressData("1"), 
            0
        ));

        // Attempt to login
        User user = userList.getUser("jdoe");
        boolean loggedIn = user != null && user.login("jdoe", "password123");

        // Verify login was successful
        assertTrue(loggedIn);

        // Verify user details
        assertEquals("jdoe", user.getUserName());
        assertEquals("jdoe@example.com", user.getEmail());
    }

    @Test
    public void testAddAccountValid() {
        // Set up UserList
        UserList userList = UserList.getInstance();

        // Add a new user account
        User newUser = new User(
            java.util.UUID.randomUUID(),
            "asmith",
            "password123",
            "asmith@example.com",
            LanguagePreference.SPANISH,
            new ProgressData("2"),
            0
        );
        userList.addUser(newUser);

        // Verify the user was added
        User retrievedUser = userList.getUser("asmith");
        assertTrue(retrievedUser != null);
        assertEquals("asmith", retrievedUser.getUserName());
    }

    @Test
    public void testLoginInvalid() {
        // Set up UserList with no users
        UserList userList = UserList.getInstance();
        userList.setUsers(new java.util.ArrayList<>());  // Clear all users for testing

        // Attempt to login with invalid credentials
        User user = userList.getUser("invalidUser");
        boolean loggedIn = user != null && user.login("invalidUser", "wrongPassword");

        // Verify login failed
        assertFalse(loggedIn);
    }
}
