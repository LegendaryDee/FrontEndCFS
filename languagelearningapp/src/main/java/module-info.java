module languagelearningapp {
    requires javafx.controls;
    requires javafx.fxml;
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
    requires transitive javafx.graphics;
    requires javafx.base;

    
    opens com.language to javafx.fxml;
    exports com.language;

    opens com.narration to javafx.fxml;
    exports com.narration;

    opens com.controllers to javafx.fxml;
    exports com.controllers;

    opens com.model to javafx.fxml;
    exports com.model;

    opens com.data to javafx.fxml;
    exports com.data;
}
