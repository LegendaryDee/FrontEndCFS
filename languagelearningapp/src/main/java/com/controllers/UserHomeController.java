package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.*;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
// import library.App;

public class UserHomeController implements Initializable {
    @FXML private Label lbl_title;
    @FXML private GridPane grid_books;
    private Library library;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        library = Library.getInstance();
        user = library.getCurrentUser();
        
        if(user != null) {
            lbl_title.setText("Welcome " + user.getUserName());
        }else{
            lbl_title.setText("Welcome, guest!");
        }
    }
    
    @FXML
    private void logout(MouseEvent event) throws IOException {
        com.language.App.setRoot("login");
    }

    @FXML
    private void courses(MouseEvent event) throws IOException {
        com.language.App.setRoot("courses");
    }

    @FXML
    private void progressdata(MouseEvent event) throws IOException {
        com.language.App.setRoot("progress_data");
    }

    @FXML
    private void practiceoptions(MouseEvent event) throws IOException {
        com.language.App.setRoot("practice_options");
    }

    @FXML
    private void addcourses(MouseEvent event) throws IOException {
        com.language.App.setRoot("add_courses");
    }

    @FXML
    private void settingsandprofile(MouseEvent event) throws IOException {
        com.language.App.setRoot("settings_and_profile");
    }

    @FXML
    private void notifications(MouseEvent event) throws IOException {
        com.language.App.setRoot("notifications");
    }
}
