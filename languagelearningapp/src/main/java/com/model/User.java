package com.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID userID;
    private String userName;
    private String password;
    private String email;
    private String firstName; // New field
    private String lastName;  // New field
    private int age;          // New field
    private String phoneNumber; // New field
    private LanguagePreference languagePreference;
    private ProgressData progressData;
    private int streakCount;
    private List<Module> modules;
    private List<Integer> scores;
    private List<Library.Course> courses;

    // Constructor
    public User(UUID userID, String userName, String password, String email, LanguagePreference languagePreference, ProgressData progressData, int streakCount) {
        this.userID = userID != null ? userID : UUID.randomUUID();
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.languagePreference = languagePreference;
        this.progressData = progressData;
        this.streakCount = streakCount;
        this.modules = new ArrayList<>();
        this.scores = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // New getters and setters for additional fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) { // Ensure valid age
            this.age = age;
        } else {
            System.out.println("Age must be positive.");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Other getters and setters
    public UUID getId() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LanguagePreference getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(LanguagePreference languagePreference) {
        this.languagePreference = languagePreference;
    }

    public ProgressData getProgressData() {
        return progressData;
    }

    public void setProgressData(ProgressData progressData) {
        this.progressData = progressData;
    }

    public int getStreakCount() {
        return streakCount;
    }

    public void setStreakCount(int streakCount) {
        this.streakCount = streakCount;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public List<Library.Course> getCourses() {
        return courses;
    }

    public void enrollInCourse(Library.Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Enrolled in course: " + course.getTitle());
        } else {
            System.out.println("Already enrolled in course: " + course.getTitle());
        }
    }

    // Login, logout, and profile management
    public void login() {
        System.out.println(userName + " has logged in.");
    }

    public boolean login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(this.userName) && inputPassword.equals(this.password)) {
            System.out.println("Login successful.");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    public void logout() {
        System.out.println(userName + " has logged out.");
    }

    public void updateProfile(String firstName, String lastName, int age, String phoneNumber, String email, LanguagePreference languagePreference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.languagePreference = languagePreference;
        System.out.println("Profile updated for " + this.userName);
    }

    // Miscellaneous methods
    public void recoverPassword() {
        System.out.println("Password recovery initiated for " + userName);
    }

    public void submitFeedback(String feedbackText) {
        System.out.println("Feedback submitted: " + feedbackText);
    }

    public int getTotalScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", languagePreference=" + languagePreference +
                ", streakCount=" + streakCount +
                ", progressData=" + progressData +
                ", modules=" + modules +
                ", courses=" + courses +
                '}';
    }

    public void updateProfile(String string, String string2, LanguagePreference spanish, int i,
            ProgressData progressData2) {
    }
}
