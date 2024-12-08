package com.model;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList instance;
    private List<User> users;

    // Private constructor to enforce singleton pattern
    private UserList() {
        users = new ArrayList<>();
    }

    // Singleton instance retrieval
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    // Add a new user
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        users.add(user);
    }

    // Retrieve a user by username
    public User getUser(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        return users.stream()
                    .filter(user -> user.getUserName().equals(username))
                    .findFirst()
                    .orElse(null);
    }

    // Retrieve all users
    public List<User> getUsers() {
        return new ArrayList<>(users); // Return a copy to preserve encapsulation
    }

    // Remove a user by username
    public boolean removeUser(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        return users.removeIf(user -> user.getUserName().equals(username));
    }

    // Check if a user exists by username
    public boolean containsUser(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        return users.stream().anyMatch(user -> user.getUserName().equals(username));
    }

    // Set the list of users (useful for resetting or initializing with a specific list)
    public void setUsers(List<User> newUsers) {
        if (newUsers == null) {
            throw new IllegalArgumentException("New users list cannot be null.");
        }
        this.users = new ArrayList<>(newUsers); // Create a copy to prevent external modification
    }
}
