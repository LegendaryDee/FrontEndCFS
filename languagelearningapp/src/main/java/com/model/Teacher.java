package com.model;


import java.util.UUID;


public class Teacher extends User {
    private String subject;

    public Teacher(UUID id, String userName, String password, String email, LanguagePreference languagePreference,
                   ProgressData progressData, int loginAttempts, String subject) {
        super(id, userName, password, email, languagePreference, progressData, loginAttempts);
        this.subject = subject;
    }

    // Getter for subject
    public String getSubject() {
        return subject;
    }

    // Setter for subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }
}
