package com.model;

import java.util.ArrayList;
import java.util.List;

public class CourseRanking {
    private String courseName;
    private List<String> participants;
    private List<Integer> scores;

    public CourseRanking(String courseName) {
        this.courseName = courseName;
        this.participants = new ArrayList<>();
        this.scores = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addParticipant(String name, int score) {
        participants.add(name);
        scores.add(score);
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void displayRankings() {
        System.out.println("Rankings for course: " + courseName);
        for (int i = 0; i < participants.size(); i++) {
            System.out.println((i + 1) + ". " + participants.get(i) + " - " + scores.get(i) + " points");
        }
    }
}
