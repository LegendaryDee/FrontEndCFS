package library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.model.LanguagePreference;
import com.model.ProgressData;
import com.model.User;
import com.model.UserList;

public class AppTests {
@Test
public void testUpdateLanguagePreference() {
    // Set up UserList and add a user
    UserList userList = UserList.getInstance();
    User user = new User(
        java.util.UUID.randomUUID(),
        "mjackson",
        "securePass",
        "mjackson@example.com",
        LanguagePreference.FRENCH,
        new ProgressData("3"),
        0
    );
    userList.addUser(user);

    // Update the language preference using a setter (assuming it exists)
    user.setLanguagePreference(LanguagePreference.GERMAN);

    // Verify the update
    assertEquals(LanguagePreference.GERMAN, user.getLanguagePreference());
}

@Test
public void testRemoveUserByClearingList() {
    // Set up UserList and add a user
    UserList userList = UserList.getInstance();
    User user = new User(
        java.util.UUID.randomUUID(),
        "jane_doe",
        "password123",
        "jane.doe@example.com",
        LanguagePreference.ENGLISH,
        new ProgressData("4"),
        0
    );
    userList.addUser(user);

    // Clear the UserList
    userList.setUsers(new java.util.ArrayList<>()); // Clear the list

    // Verify the user list is empty
    assertTrue(userList.getUsers().isEmpty());
}

@Test
public void testUpdateProgressManually() {
    // Set up a User with ProgressData
    ProgressData progressData = new ProgressData("1");
    User user = new User(
        java.util.UUID.randomUUID(),
        "charlie",
        "pass1234",
        "charlie@example.com",
        LanguagePreference.SPANISH,
        progressData,
        0
    );

    // Update progress by setting a new ProgressData object (if no `updateProgress` exists)
    user.setProgressData(new ProgressData("2"));

    // Verify the progress was updated
    assertEquals("2", user.getProgressData().getId());
}

@Test
public void testUserListSingletonBehavior() {
    // Retrieve two instances of UserList
    UserList instance1 = UserList.getInstance();
    UserList instance2 = UserList.getInstance();

    // Verify both instances are the same
    assertTrue(instance1 == instance2);
}

@Test
public void testInvalidEmailCheckManually() {
    // Create a user with an invalid email
    User invalidEmailUser = new User(
        java.util.UUID.randomUUID(),
        "user123",
        "pass5678",
        "invalid-email",
        LanguagePreference.ENGLISH,
        new ProgressData("5"),
        0
    );

    // Check if email contains "@" and a domain
    boolean isValidEmail = invalidEmailUser.getEmail().contains("@") &&
                           invalidEmailUser.getEmail().contains(".");

    // Verify email validation fails
    assertFalse(isValidEmail);
}

}
