package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lesson {
    private String title;
    private String content;
    private UUID id;
    private int duration;
    private UUID lessonID;
    private List<Topic> topics;

    // Constructor with UUID, title, content, and duration
    public Lesson(UUID lessonID, String title, String content, int duration) {
        this.title = title;
        this.content = content;
        this.id = UUID.randomUUID();
        this.lessonID = lessonID;
        this.duration = duration;
    }

    // Constructor with UUID, title, and content (no duration)
    public Lesson(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.lessonID = UUID.randomUUID(); // You can adjust this as necessary.
        this.duration = 0;  // Default duration to 0, since it's not provided.
    }

    // Constructor with only title and content
    public Lesson(String title, String content) {
        this.title = title;
        this.content = content;
        this.id = UUID.randomUUID();  // Generate new ID by default.
        this.lessonID = UUID.randomUUID(); // Generate new lesson ID.
        this.duration = 0; // Default duration to 0, since it's not provided.
    }
    
    public void startLesson() {
        System.out.println("Starting lesson: " + title);
    }

    public void completeLesson() {
        System.out.println("Completing lesson: " + title);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Topic> getTopics() {
        return topics;
    }
    
    public void setTopics(List<Topic> topics) {
        if(this.topics == null) {
            this.topics = new ArrayList<>();
        }
        this.topics = topics;
    }

    public UUID getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getLessonID() {
        return lessonID.toString();
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id + 
                ", title='" + title + '\'' + 
                ", content='" + content + '\'' + 
                ", duration=" + duration + 
                '}';
    }
}
