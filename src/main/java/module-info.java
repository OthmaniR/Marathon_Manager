module com.example.marathon_manager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.marathon_manager to javafx.fxml;
    exports com.example.marathon_manager;

    opens Model to javafx.base;
}