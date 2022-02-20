module com.example.muzeumfrontendjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.muzeumfrontendjavafx to javafx.fxml;
    exports com.example.muzeumfrontendjavafx;
    exports com.example.muzeumfrontendjavafx.controllers;
    opens com.example.muzeumfrontendjavafx.controllers to javafx.fxml;
}