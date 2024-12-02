package com.controllers;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotificationsController {
    @FXML
    private ListView<String> notificationsListView;

    private ObservableList<String> notifications;

    @FXML
    public void initialize() {
        // Initialize the notifications list with some sample data
        notifications = FXCollections.observableArrayList(
            "New message received",
            "System update available",
            "Reminder: Meeting at 3 PM"
        );

        // Bind the list to the ListView
        notificationsListView.setItems(notifications);
    }

    @FXML
    private void clearAllNotifications() {
        if (notifications.isEmpty()) {
            showAlert("No Notifications", "There are no notifications to clear.");
        } else {
            notifications.clear();
            showAlert("Success", "All notifications cleared.");
        }
    }

    @FXML
    private void dismissSelectedNotification() {
        String selectedNotification = notificationsListView.getSelectionModel().getSelectedItem();
        if (selectedNotification == null) {
            showAlert("No Selection", "Please select a notification to dismiss.");
        } else {
            notifications.remove(selectedNotification);
            showAlert("Success", "Notification dismissed.");
        }
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
