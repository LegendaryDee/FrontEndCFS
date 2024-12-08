package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Library;
import com.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignupController implements Initializable {
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private TextField txt_first_name;
    @FXML
    private TextField txt_last_name;
    @FXML
    private TextField txt_age;
    @FXML
    private TextField txt_phone_number;
    @FXML
    private Label lbl_error;

    @FXML
    private void btnSignupClicked(ActionEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();
        String firstName = txt_first_name.getText();
        String lastName = txt_last_name.getText();
        int age;
        String phoneNumber = txt_phone_number.getText();

        try {
            age = Integer.parseInt(txt_age.getText());
            if (age <= 0) {
                lbl_error.setText("Age must be a positive number.");
                return;
            }
        } catch (Exception e) {
            lbl_error.setText("Sorry, you must enter a valid age.");
            return;
        }

        if (phoneNumber.isEmpty()) {
            lbl_error.setText("Phone number cannot be  empty.");
            return;
        }

        if (!phoneNumber.matches("[0-9\\-]+")) {
            lbl_error.setText("Phone number can only contain digits and dashes.");
            return;
        }

        if (phoneNumber.length() < 12 || phoneNumber.length() > 12) {
            lbl_error.setText("Phone number must be a 12 digit number.");
            return;
        }

        // check for empty fields
        if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            lbl_error.setText("Sorry, You cannot leave blank fields");
            return;
        }

        Library library = Library.getInstance();

        if (!library.createAccount(username, firstName, lastName, age, phoneNumber)) {
            lbl_error.setText("Username already exists. Please choose another.");
            return;
        }

        library.addUser(new User(null, username, password, phoneNumber, null, null, age));
        library.login(username);
        com.language.App.setRoot("login");
        // com.language.App.setRoot("user_home");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.language.App.setRoot("home");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
