package com.example.marathon_manager;

import Model.Db_Connect;
import Model.Marathon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DashboardController {
    @FXML
    private Button chrono_btn;



    @FXML
    private Label lbl_status;

    @FXML
    private Label lbl_status_mini;

    @FXML
    private Button marathon_btn;

    @FXML
    private Button participation_btn;

    @FXML
    private Pane pnl_status;

    @FXML
    private Button runner_btn;

    @FXML
    private Button sponsor_btn;

    @FXML
    private Button insert_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button test_btn;

    @FXML
    private TextField marathon_id_text;
    @FXML
    private TextField name_text;

    @FXML
    private TextField start_location_text;

    @FXML
    private TextField finish_location_text;

    @FXML
    private TextField distance_text;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<Marathon> marathonTable;
    @FXML
    private TableColumn<Marathon, Integer> marathonIdColumn;
    @FXML
    private TableColumn<Marathon, String> nameColumn;
    @FXML
    private TableColumn<Marathon, Date> dateColumn;
    @FXML
    private TableColumn<Marathon, String> startLocationColumn;
    @FXML
    private TableColumn<Marathon, String> finishLocationColumn;
    @FXML
    private TableColumn<Marathon, String> distanceColumn;


    public void initialize_Marathon() {
        // Set up table columns
        marathonIdColumn.setCellValueFactory(new PropertyValueFactory<>("marathonId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        startLocationColumn.setCellValueFactory(new PropertyValueFactory<>("startLocation"));
        finishLocationColumn.setCellValueFactory(new PropertyValueFactory<>("finishLocation"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));

        // Set up data in the table
     //   marathonTable.setItems(getMarathons());
    }
  /*  public static ObservableList<Marathon> getMarathons() {
        ObservableList<Marathon> marathons = FXCollections.observableArrayList();

        try (
                Connection con = Db_Connect.Connect_Db();
                Statement stmt = con.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM marathon")) {

            while (resultSet.next()) {
                int marathonId = resultSet.getInt("marathon_id");
                String name = resultSet.getString("name");
                Date date = Date.valueOf(resultSet.getString("date"));
                String startLocation = resultSet.getString("start_location");
                String finishLocation = resultSet.getString("finish_location");
                String distance = resultSet.getString("distance");
                String dateString = date.toString();
                Marathon marathon = new Marathon(marathonId, name, dateString, startLocation, finishLocation, distance);
                marathons.add(marathon);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return marathons;
    }
*/

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == marathon_btn){
            lbl_status.setText("Marathon");
            lbl_status_mini.setText("Marathon");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Marathon-view.fxml");
        }else if(event.getSource() == runner_btn){
            lbl_status.setText("Runner");
            lbl_status_mini.setText("Runner");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Runner-view.fxml");
        }else if(event.getSource() == sponsor_btn){
            lbl_status.setText("Sponsor");
            lbl_status_mini.setText("Sponsor");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));

        }else if(event.getSource() == participation_btn) {
            lbl_status.setText("Participation");
            lbl_status_mini.setText("Participation");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Participant.fxml");
        }else if(event.getSource() == chrono_btn) {
            lbl_status.setText("Chrono");
            lbl_status_mini.setText("Chrono");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));

        }else if(event.getSource() == dashboard_btn) {
            lbl_status.setText("Dashboard");
            lbl_status_mini.setText("Dashboard");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Dashboard.fxml");
        }

    }
    @FXML
    private void open_test() {
    }


    private void showInterface(String name) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource(name));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
            System.out.println(name + " is opened   ");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    @FXML
    private void dashboard_close() {
        System.exit(0);
    }
}
