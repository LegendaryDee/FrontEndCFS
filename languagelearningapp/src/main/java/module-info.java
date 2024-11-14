module languagelearningapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens languagelearningapp to javafx.fxml;
    opens com.language to javafx.fxml;
    opens com.language;
    opens com.controllers to javafx.fxml;
    exports com.language;
    exports languagelearningapp;
}
