module languagelearningapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires json.simple;
    requires jlayer;
    requires software.amazon.awssdk.core;
    requires software.amazon.awssdk.services.polly;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.utils;
    requires org.slf4j;
    requires org.slf4j.simple;
    requires software.amazon.awssdk.awscore;
    requires software.amazon.eventstream;

    opens com.language to javafx.fxml;
<<<<<<< HEAD
    opens com.language;
    opens com.controllers to javafx.fxml;
    exports com.language;
=======
    exports com.language;

    opens languagelearningapp to javafx.fxml;
>>>>>>> c77d676366af4f84be39815770c4a0f1164526a6
    exports languagelearningapp;

    opens com.narration to javafx.fxml;
    exports com.narration;
}