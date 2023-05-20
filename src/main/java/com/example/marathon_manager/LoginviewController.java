package com.example.marathon_manager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginviewController {


    @FXML
    private AnchorPane login;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField password;

    @FXML
    private TextField username;


    @FXML
    private Button login_button;

    @FXML
    private Button close;

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet result;

    public void loginAdmin() {
            String sql = "SELECT * FROM admin WHERE username=? AND password=?";


        try {
            conn = Model.Db_Connect.Connect_Db();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            result = ps.executeQuery();
            Alert alert;
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter username and password");
                alert.showAndWait();
            } else if (result.next()) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Login Successful");
                alert.showAndWait();
                showDashboardInterface();

            } else {
                System.out.println("Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void showDashboardInterface() throws Exception {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }





    public void close() {
        System.exit(0);
    }
}
