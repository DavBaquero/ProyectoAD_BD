module edu.badpals.proyectoad_bd {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.desktop;
    requires com.google.gson;
    requires java.sql;

    opens edu.badpals.proyectoad_bd.Model to javafx.base, com.google.gson;

    opens edu.badpals.proyectoad_bd to javafx.fxml, javafx.graphics;
    exports edu.badpals.proyectoad_bd.Controller to javafx.fxml;
    opens edu.badpals.proyectoad_bd.Controller to javafx.fxml;
}