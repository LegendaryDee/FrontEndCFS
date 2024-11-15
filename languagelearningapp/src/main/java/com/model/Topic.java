package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class Topic {
    private UUID id;
    private ArrayList<Lesson> lessons;
    private ArrayList<Exercise> exercises;
    private Assessment assessment;
    private String title;
    private String content;

    public Topic(Assessment assessment, String title, String content) {
        this.id = UUID.randomUUID();
        this.lessons = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.assessment = assessment;
        this.title = title;
        this.content = content;
    }
    
    public Topic( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public String getTitle() {
        return title;
    }
}
