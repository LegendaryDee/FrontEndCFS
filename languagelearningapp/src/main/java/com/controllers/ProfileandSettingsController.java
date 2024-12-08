package com.controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class ProfileandSettingsController {
    private static final String PROFILE_FILE = "profile.txt";
    private static final String SETTINGS_FILE = "settings.txt";

    @FXML
    private TextField nameField, emailField, phoneField;
    @FXML
    private CheckBox notificationsCheckBox, darkModeCheckBox, onlineStatusCheckBox;
    @FXML
    private ComboBox<String> languageComboBox;
    @FXML
    private ImageView profileImage;

    public void saveProfile() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROFILE_FILE))) {
            writer.write(name + "\n");
            writer.write(email + "\n");
            writer.write(phone + "\n");
            System.out.println("Profile saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save profile: " + e.getMessage());
        }
    }

    public void saveSettings() {
        boolean notifications = notificationsCheckBox.isSelected();
        boolean darkMode = darkModeCheckBox.isSelected();
        boolean showOnlineStatus = onlineStatusCheckBox.isSelected();
        String language = languageComboBox.getValue();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SETTINGS_FILE))) {
            writer.write(notifications + "\n");
            writer.write(darkMode + "\n");
            writer.write(showOnlineStatus + "\n");
            writer.write(language + "\n");
            System.out.println("Settings saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save settings: " + e.getMessage());
        }
    }

    @FXML
    public void initialize() {
        loadProfile();
        loadSettings();
        languageComboBox.getItems().addAll("English", "Spanish", "French", "German");
    }

    private void loadProfile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROFILE_FILE))) {
            String name = reader.readLine();
            String email = reader.readLine();
            String phone = reader.readLine();

            nameField.setText(name);
            emailField.setText(email);
            phoneField.setText(phone);
            System.out.println("Profile loaded successfully.");
        } catch (IOException e) {
            System.out.println("No existing profile found: " + e.getMessage());
        }
    }

    private void loadSettings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SETTINGS_FILE))) {
            boolean notifications = Boolean.parseBoolean(reader.readLine());
            boolean darkMode = Boolean.parseBoolean(reader.readLine());
            boolean showOnlineStatus = Boolean.parseBoolean(reader.readLine());
            String language = reader.readLine();

            notificationsCheckBox.setSelected(notifications);
            darkModeCheckBox.setSelected(darkMode);
            onlineStatusCheckBox.setSelected(showOnlineStatus);
            languageComboBox.setValue(language);
            System.out.println("Settings loaded successfully.");
        } catch (IOException e) {
            System.out.println("No existing settings found: " + e.getMessage());
        }
    }

@FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }
}
