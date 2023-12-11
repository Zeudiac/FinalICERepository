module com.example.fxtesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxtesting to javafx.fxml;
    exports com.example.fxtesting;
}