module languagelearningapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens languagelearningapp to javafx.fxml;
    exports languagelearningapp;
}
