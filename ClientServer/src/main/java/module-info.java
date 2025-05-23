module com.example.chatap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatapp.controller to javafx.fxml;
    exports com.example.chatapp;


}