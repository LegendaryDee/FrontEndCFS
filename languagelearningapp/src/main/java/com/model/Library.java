package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {
        // Singleton instance
    private static Library instance;

    // Fields
    private String username;
    private User currentUser; // Stores the currently logged-in user
    private List<User> users; // List of registered users
    private List<Course> courses; // Example list of courses in the library

    // Private constructor to enforce singleton pattern
    private Library() {
        users = new ArrayList<>();
        courses = new ArrayList<>();
        // Add sample courses to the library
        courses.add(new Course("Introduction to Spanish"));
        courses.add(new Course("Advanced Spanish Grammar"));
        courses.add(new Course("Spanish Conversation Skills"));
    }

    // Get the singleton instance
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    // Get the currently logged-in user
    public User getCurrentUser() {
        return currentUser;
    }

    // Set the currently logged-in user
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User authenticateUser(String username, String password) {
        if("user".equals(username) && "password".equals(password)) {
            return new User(UUID.randomUUID(), username, password, null, null, null, 0);
        }
        return null;
    }

    // Create a new account
    public boolean createAccount(String username, String firstName, String lastName, int age, String phoneNumber) {
        // Check if the username is already taken
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                return false; // Username already exists
            }
        }

        // Create and add a new user
        User newUser = new User(
                UUID.randomUUID(),
                username,
                "defaultPassword", // Temporary default password
                firstName + "@example.com", // Temporary email
                LanguagePreference.ENGLISH, // Default language
                new ProgressData(UUID.randomUUID().toString()),
                1
        );
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAge(age);
        newUser.setPhoneNumber(phoneNumber);

        users.add(newUser);
        return true;
    }

    // Log in a user by username
    public boolean login(String username) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                currentUser = user;
                return true; // Login successful
            }
        }
        return false; // User not found
    }

    // Logout method
    public void logout() {
        if (currentUser != null) {
            System.out.println(currentUser.getUserName() + " is logging out...");
            currentUser = null; // Reset the current user
            System.out.println("You have successfully logged out.");
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    // Get the list of courses
    public List<Course> getCourses() {
        return courses;
    }

    // Add a new course to the library
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Example Course class (inner class for simplicity)
    public static class Course {
        private String title;

        public Course(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
