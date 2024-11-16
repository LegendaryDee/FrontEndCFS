package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
// import library.App;

public class LoginController implements Initializable {
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_error;

    @FXML
    private void btnLoginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        Library library = Library.getInstance();

        if (!library.login(username)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }
        if (!library.login(password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }

        com.library.App.setRoot("user_home");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        com.library.App.setRoot("home");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
