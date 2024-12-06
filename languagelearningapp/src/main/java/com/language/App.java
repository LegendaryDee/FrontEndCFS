package com.language;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Correct path for loading FXML file
        scene = new Scene(loadFXML("add_courses"), 640, 480);
        scene = new Scene(loadFXML("home"), 640, 480);
        // Set the title for the stage
        stage.setTitle("El Chicos Language Learning App");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        // Use a classpath-relative path with a leading slash to ensure it's located in the resources folder
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        System.out.println(fxmlLoader.toString());
        if (fxmlLoader.getLocation() == null) {
            throw new IOException("FXML file not found: " + fxml + ".fxml");
        }
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
