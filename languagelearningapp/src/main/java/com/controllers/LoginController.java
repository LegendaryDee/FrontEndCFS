package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable {
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_error;

    @FXML
    private void onLogin(ActionEvent event) throws IOException {
        try {
            String username = txt_username.getText();
            String password = txt_password.getText();
    
            System.out.println("Logging in with username: " + username);
    
            Library library = Library.getInstance();
            User user = library.authenticateUser(username, password);
    
            if (user != null) {
                System.out.println("Authentication successful. Redirecting to user_home...");
                library.setCurrentUser(user);
                com.language.App.setRoot("user_home");
            } else {
                System.out.println("Invalid credentials.");
                lbl_error.setText("Invalid username or password.");
                lbl_error.setVisible(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
            lbl_error.setText("Error occurred during login.");
            lbl_error.setVisible(true);
        }
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("home");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
