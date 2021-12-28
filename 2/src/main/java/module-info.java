module com.example._2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._2 to javafx.fxml;
    exports com.example._2;
}