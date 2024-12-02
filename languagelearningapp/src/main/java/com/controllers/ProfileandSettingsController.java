package com.controllers;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class ProfileandSettingsController {
    @FXML
    private ImageView profileImage;

    @FXML
    private TextField nameField, emailField, phoneField;

    public void saveProfile() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        // Save the details (e.g., to a database or file)
        System.out.println("Profile saved: " + name + ", " + email + ", " + phone);
}

@FXML
private CheckBox notificationsCheckBox, darkModeCheckBox, onlineStatusCheckBox;

@FXML
private ComboBox<String> languageComboBox;

public void saveSettings() {
    boolean notifications = notificationsCheckBox.isSelected();
    boolean darkMode = darkModeCheckBox.isSelected();
    boolean showOnlineStatus = onlineStatusCheckBox.isSelected();
    String language = languageComboBox.getValue();

    // Save the settings (e.g., to a configuration file)
    System.out.println("Settings saved: " + notifications + ", " + darkMode + ", " + showOnlineStatus + ", " + language);
}

@FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }

@FXML
public void initialize() {
    // Populate the ComboBox programmatically
    languageComboBox.getItems().addAll("English", "Spanish", "French", "German");
}
}
