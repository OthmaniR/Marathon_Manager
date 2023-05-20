package com.example.marathon_manager;

import Model.Db_Connect;
import Model.Marathon;
import Model.Runner;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class RunnerController {

    @FXML
    private TableColumn<Runner, String> runnerIdColumn;

    @FXML
    private TableColumn<Runner, String> nameColumn;

    @FXML
    private TableColumn<Runner, Date> ageColumn;

    @FXML
    private TableColumn<Runner, String> genderColumn;

    @FXML
    private TableColumn<Runner, String> emailColumn;

    @FXML
    private TableColumn<Runner, String> phoneColumn;

    @FXML
    private Button chrono_btn;

    @FXML
    private Button dashboard_btn;



    @FXML
    private Label lbl_status;

    @FXML
    private Label lbl_status_mini;

    @FXML
    private TableView<Runner> Runner_Table;

    @FXML
    private Button marathon_btn;
    @FXML
    private Button participation_btn;



    @FXML
    private Pane pnl_status;

    @FXML
    private TextField runner_age_text;

    @FXML
    private Button runner_btn;

    @FXML
    private TextField runner_email_text;

    @FXML
    private TextField runner_gender_text;

    @FXML
    private TextField runner_id_text;

    @FXML
    private TextField runner_name_text;

    @FXML
    private TextField runner_phone_text;

    @FXML
    private Button sponsor_btn;

    @FXML
    private Button test_btn;

    public void initialize_Runner(){
        runnerIdColumn.setCellValueFactory(new PropertyValueFactory<>("runnerId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        Runner_Table.getRunner();
    }

    public static ObservableList<Runner> getRunner() {

        ObservableList<Runner> Runners = FXCollections.observableArrayList();

        Runners.clear();
        try (
                Connection con = Db_Connect.Connect_Db();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM runner");
                ResultSet resultSet = stmt.executeQuery()
        ) {
            while (resultSet.next()) {
                int runnerId = resultSet.getInt("runner_id");
                String name = resultSet.getString("name");
                LocalDate date = resultSet.getDate("age").toLocalDate();
                String age = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                Runner runner = new Runner(runnerId, name, date, age, email,phoneNumber);
                Runners.add(runner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load marathons from the database.");
        }

        return marathons;
    }

    public void showRunner() {
        Runner selectedRunner = Runner_Table.getSelectionModel().getSelectedItem();
        if (selectedRunner != null) {
            runnerIdText.setText(selectedRunner.getRunnerId());
            runnerNameText.setText(selectedRunner.getName());
            runnerAgeText.setText(String.valueOf(selectedRunner.getAge()));
            runnerGenderText.setText(selectedRunner.getGender());
            runnerEmailText.setText(selectedRunner.getEmail());
            runnerPhoneText.setText(selectedRunner.getPhone());
        }
    }


    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
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
            Stage stage = (Stage) participation_btn.getScene().getWindow();
            // do what you have to do
            stage.close();
        }


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


    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    }
