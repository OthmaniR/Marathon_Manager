module com.example.marathon_manager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.marathon_manager to javafx.fxml;
    exports com.example.marathon_manager;
}