package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
// import library.App;
import javafx.scene.input.MouseEvent;

public class HomeController implements Initializable {

    @FXML
    private void onLoginClicked(ActionEvent event) throws IOException {
        com.language.App.setRoot("login");
    }

    @FXML
    private void onSignupClicked(ActionEvent event) throws IOException {
        com.language.App.setRoot("signup");
    }

    @FXML
    private void onSigninAsGuestClicked(MouseEvent event) throws IOException {
        com.language.App.setRoot("user_home");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}