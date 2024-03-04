module com.example.javafxbarchart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxbarchart to javafx.fxml;
    exports com.example.javafxbarchart;

    requires java.sql;
}