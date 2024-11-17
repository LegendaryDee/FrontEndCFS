package library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.model.Course;
import com.model.CourseList;
import com.model.DataWriter;
import com.model.LanguagePreference;
import com.model.ProgressData;
import com.model.User;
import com.model.UserList;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SavingTests {

    private static final String USER_FILE_NAME = "path/to/users.json";  // Update to your actual path
    private static final String COURSE_FILE_NAME = "path/to/courses.json";  // Update to your actual path

    @Test
    public void testSaveUsers() {
        // Set up UserList and add test users
        UserList userList = UserList.getInstance();
        userList.setUsers(new java.util.ArrayList<>());  // Clear existing users for the test

        User testUser1 = new User(
            java.util.UUID.randomUUID(),
            "jdoe",
            "password123",
            "jdoe@example.com",
            LanguagePreference.ENGLISH,
            new ProgressData("1"),
            0
        );

        User testUser2 = new User(
            java.util.UUID.randomUUID(),
            "asmith",
            "password123",
            "asmith@example.com",
            LanguagePreference.SPANISH,
            new ProgressData("2"),
            0
        );

        userList.addUser(testUser1);
        userList.addUser(testUser2);

        // Save the users to the JSON file
        DataWriter.saveUsers(userList.getUsers());

        // Load the saved file and verify its contents
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            assertEquals(2, usersJSON.size());  // Ensure two users were saved

            // Check first user's details
            JSONObject user1JSON = (JSONObject) usersJSON.get(0);
            assertEquals("jdoe", user1JSON.get("userName"));
            assertEquals("jdoe@example.com", user1JSON.get("email"));
            assertEquals("ENGLISH", user1JSON.get("languagePreference"));

            // Check second user's details
            JSONObject user2JSON = (JSONObject) usersJSON.get(1);
            assertEquals("asmith", user2JSON.get("userName"));
            assertEquals("asmith@example.com", user2JSON.get("email"));
            assertEquals("SPANISH", user2JSON.get("languagePreference"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("An exception occurred during the test: " + e.getMessage(), false);
        }
    }

    @Test
    public void testSaveCourses() {
        // Set up CourseList and add test courses
        CourseList courseList = CourseList.getInstance();
        courseList.setCourses(new java.util.ArrayList<>());  // Clear existing courses for the test

        Course testCourse1 = new Course(
            java.util.UUID.randomUUID(),
            "Spanish Basics",
            LanguagePreference.SPANISH,
            "A beginner's guide to Spanish",
            new Teacher(
                java.util.UUID.randomUUID(),
                "teacher1",
                "password123",
                "teacher1@example.com",
                LanguagePreference.SPANISH,
                new ProgressData("3"),
                0
            )
        );

        Course testCourse2 = new Course(
            java.util.UUID.randomUUID(),
            "English Advanced",
            LanguagePreference.ENGLISH,
            "An advanced guide to English",
            new Teacher(
                java.util.UUID.randomUUID(),
                "teacher2",
                "password123",
                "teacher2@example.com",
                LanguagePreference.ENGLISH,
                new ProgressData("4"),
                0
            )
        );

        courseList.addCourse(testCourse1);
        courseList.addCourse(testCourse2);

        // Save the courses to the JSON file
        DataWriter.saveCourses(courseList.getCourses());

        // Load the saved file and verify its contents
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray coursesJSON = (JSONArray) parser.parse(reader);

            assertEquals(2, coursesJSON.size());  // Ensure two courses were saved

            // Check first course's details
            JSONObject course1JSON = (JSONObject) coursesJSON.get(0);
            assertEquals("Spanish Basics", course1JSON.get("title"));
            assertEquals("SPANISH", course1JSON.get("language"));
            assertEquals("A beginner's guide to Spanish", course1JSON.get("description"));

            // Check second course's details
            JSONObject course2JSON = (JSONObject) coursesJSON.get(1);
            assertEquals("English Advanced", course2JSON.get("title"));
            assertEquals("ENGLISH", course2JSON.get("language"));
            assertEquals("An advanced guide to English", course2JSON.get("description"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("An exception occurred during the test: " + e.getMessage(), false);
        }
    }
}
