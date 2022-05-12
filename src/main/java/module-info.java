module com.example.runningcat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.runningcat to javafx.fxml;
    exports com.example.runningcat;
}