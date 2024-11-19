package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
// import library.App;

public class HomeController implements Initializable {

    @FXML
    private void onLoginClicked(ActionEvent event) throws IOException {
        com.language.App.setRoot("login");
    }

    @FXML
    private void onSignupClicked(ActionEvent event) throws IOException {
        com.language.App.setRoot("signup");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}