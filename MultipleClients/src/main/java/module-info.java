module org.example.chatapptest {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.app.multiclient to javafx.fxml;
    opens lk.app.multiclient.client to javafx.fxml;
    opens lk.app.multiclient.server to javafx.fxml;
    exports lk.app.multiclient;
}