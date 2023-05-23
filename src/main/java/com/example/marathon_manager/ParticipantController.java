package com.example.marathon_manager;

import Model.Db_Connect;
import Model.Marathon;
import Model.Participation;
import Model.Runner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ParticipantController implements Initializable {


    @FXML
    private CheckBox Payed_CheckBox;

    @FXML
    public  ComboBox maraCombox;

    @FXML
    private Button addnewBtn;



    @FXML
    private Button chrono_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button insert_btn;

    @FXML
    private Label lbl_status;

    @FXML
    private Label lbl_status_mini;

    @FXML
    private TextField ageFields;

    @FXML
    private TextField participationIdText;


    @FXML
    private TextField RunFirstTxt;


    @FXML
    private TextField RunLastTxt;

    @FXML
    private Button marathon_btn;

    @FXML
    private Button participation_btn;



    @FXML
    private Pane pnl_status;



    @FXML
    private Button runner_btn;

    @FXML
    private Button show_btn;

    @FXML
    private Button sponsor_btn;

    @FXML
    private Button sponsor_btn1;

    @FXML
    private Button test_btn;

    @FXML
    private Button updateBtn;

    @FXML
    private DatePicker registerDatepicker;

    @FXML
    private TableView<Participation> participationTable;
    @FXML
    private TableColumn<Participation, Integer> participationIdColumn;
    @FXML
    private TableColumn<Participation, String> marathonNameColumn;
    @FXML
    private TableColumn<Participation, Integer> runnerIdColumn;
    @FXML
    private TableColumn<Participation, String> firstNameColumn;
    @FXML
    private TableColumn<Participation, String> lastNameColumn;
    @FXML
    private TableColumn<Participation, LocalDate> registrationDateColumn;
    @FXML
    private TableColumn<Participation, Boolean> paymentStatusColumn;

    @FXML
    private TableView<Runner> runnerTable;
    @FXML
    private TableColumn<Participation, String> marathonNameColumn1;
    @FXML
    private TableColumn<Participation, String> firstNameColumn1;
    @FXML
    private TableColumn<Participation, Integer> ageColumn;
    @FXML
    private TableColumn<Participation, String> lastNameColu;

    @FXML
    private HBox participationIdhbox;


    @FXML
    private HBox RunnerHbox;


    @FXML
    private Label registerLbl;

    public static int Ma_Id = 0;
    public static int runnerId = 0;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if (event.getSource() == marathon_btn) {
            lbl_status.setText("Marathon");
            lbl_status_mini.setText("Marathon");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Marathon-view.fxml");
        } else if (event.getSource() == runner_btn) {
            lbl_status.setText("Runner");
            lbl_status_mini.setText("Runner");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Runner-view.fxml");
        } else if (event.getSource() == sponsor_btn) {
            lbl_status.setText("Sponsor");
            lbl_status_mini.setText("Sponsor");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Sponsor-view.fxml");
            Stage stage = (Stage) sponsor_btn.getScene().getWindow();
            stage.close();
        } else if (event.getSource() == participation_btn) {
            lbl_status.setText("Participation");
            lbl_status_mini.setText("Participation");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Participation-view.fxml");
            Stage stage = (Stage) participation_btn.getScene().getWindow();
            stage.close();
        } else if (event.getSource() == chrono_btn) {
            lbl_status.setText("Chrono");
            lbl_status_mini.setText("Chrono");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Chrono-view.fxml");
            Stage stage = (Stage) chrono_btn.getScene().getWindow();
            stage.close();
        } else if (event.getSource() == dashboard_btn) {
            lbl_status.setText("Dashboard");
            lbl_status_mini.setText("Dashboard");
            pnl_status.setBackground(new Background(new BackgroundFill(Color.rgb(29, 38, 125), CornerRadii.EMPTY, Insets.EMPTY)));
            showInterface("Dashboard.fxml");
        }
    }

    public void initialize_Participation() {
        participationTable.setVisible(true);
        runnerTable.setVisible(false);
        participationIdhbox.setVisible(false);
        RunnerHbox.setVisible(true);
        participationIdColumn.setCellValueFactory(new PropertyValueFactory<>("participation_id"));
        marathonNameColumn.setCellValueFactory(new PropertyValueFactory<>("MarathonName"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<>("registration_date"));
        paymentStatusColumn.setCellValueFactory(new PropertyValueFactory<>("payment_status"));
        participationTable.setItems(getParticipation());

    }
    public void initialize_Waiting_list() {
        participationTable.setVisible(false);
        runnerTable.setVisible(true);
        participationIdhbox.setVisible(true);
        RunnerHbox.setVisible(false);
        registerLbl.setVisible(true);
        registerDatepicker.setVisible(true);
        Payed_CheckBox.setVisible(true);
        marathonNameColumn1.setCellValueFactory(new PropertyValueFactory<>("MarathonName"));
        firstNameColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNameColu.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        runnerTable.setItems(getWaitingList());

    }

    public  ObservableList<Participation> getParticipation() {
        int id = getidMarathon();
        int participation_id = 0;
        int marathon_id = 0;
        int runner_id = 0;
        String marathon_name = null;
        LocalDate registration_date = null;
        String runner_first_name = null;
        String runner_last_name = null;
        ObservableList<Participation> participations = FXCollections.observableArrayList();
        participations.clear();
        try (
                Connection con = Db_Connect.Connect_Db();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM participation WHERE marathon_id = ?");
                PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM marathon WHERE marathon_id = ?");
                PreparedStatement stmt3 = con.prepareStatement("SELECT * FROM runner WHERE runner_id = ?");



        ) {
            System.out.println(id +"raja");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {

                 participation_id = resultSet.getInt("participation_id");
                 marathon_id = resultSet.getInt("marathon_id");
                 runner_id = resultSet.getInt("runner_id");
                 registration_date = resultSet.getDate("registration_date").toLocalDate();
                String payment_status = resultSet.getString("payment_status");
                System.out.println(id +"raja");
                stmt2.setInt(1, id);
                ResultSet resultSet2 = stmt2.executeQuery();
                    while (resultSet2.next()){

                         marathon_name = resultSet2.getString("name");}
                        stmt3.setInt(1, runner_id);
                        ResultSet resultSet3 = stmt3.executeQuery();
                    while (resultSet3.next()) {

                        runner_first_name = resultSet3.getString("first_name");
                        runner_last_name = resultSet3.getString("last_name");
                    }
                Participation participation = new Participation(participation_id, marathon_id, marathon_name, runner_id, runner_first_name, runner_last_name, registration_date, payment_status);
                participations.add(participation);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error on Building Data");
        }
        return participations;
    }

    public  ObservableList<Runner> getWaitingList() {
        int id = getidMarathon();
        int participation_id = 0;
        int marathon_id = 0;
        int runner_id = 0;
        String marathon_name = null;
        LocalDate registration_date = null;
        String runner_first_name = null;
        String runner_last_name = null;
        ObservableList<Runner> runners = FXCollections.observableArrayList();
        runners.clear();
        try (
                Connection con = Db_Connect.Connect_Db();
                //PreparedStatement stmt = con.prepareStatement("SELECT * FROM participation where marathon_id = ?");
                PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM marathon WHERE marathon_id = ?");
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM runner WHERE Payment_status = ?");



        ) {

            System.out.println(id);
            stmt.setString(1, "Not paid");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                 runnerId = resultSet.getInt("runner_id");
                int marathonId = resultSet.getInt("marathon_id");
                String name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone_number");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                System.out.println(id);
                stmt1.setInt(1, id);
                ResultSet resultSet2 = stmt1.executeQuery();
                while (resultSet2.next()){


                String marathonName = resultSet2.getString("name");
                System.out.println(marathonName);
                Runner runner = new Runner(runnerId, name, last_name, marathonId, marathonName, age,gender,email,phone);
                runners.add(runner);
            }}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return runners;
    }
    @FXML
    void addnewbtn(ActionEvent event) {
        addnewBtn.setVisible(false);
        insert_btn.setVisible(true);

    }


    @FXML
    void addnew_marathon(ActionEvent event) {

    }

    @FXML
    void deleteMarathon(ActionEvent event) {

    }





    @FXML
    void updateMarathon(ActionEvent event) {

    }

    public void Marathon_Name_Combobox() {

        String s = "";
        if (maraCombox.getValue() != null) {
            s = (String) maraCombox.getValue();
            System.out.println(s);
        } else {
            System.out.println("No value selected");
        }
    }

    @FXML
    public void select_Combobox(javafx.scene.input.MouseEvent mouseEvent) {
        try (Connection con = Db_Connect.Connect_Db();
             PreparedStatement stmt = con.prepareStatement("Select name  FROM marathon ")) {
            ObservableList data = FXCollections.observableArrayList();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                data.add(resultSet.getString("name"));
            }
            maraCombox.setItems(data);

        } catch ( SQLException e) {
            System.out.println("Error");
        }
    }

    public  int getidMarathon(){
        String marathon_name = maraCombox.getValue().toString();
        try (
                Connection con = Db_Connect.Connect_Db();
                PreparedStatement stmt = con.prepareStatement("SELECT marathon_id FROM marathon WHERE name = ?")){
            stmt.setString(1, marathon_name); // Set the name parameter
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Ma_Id =  resultSet.getInt("marathon_id");
            }
            System.out.println(Ma_Id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Ma_Id;
    }



    public void getSelectedColu(javafx.scene.input.MouseEvent mouseEvent) {

        int index = runnerTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        RunFirstTxt.setText(firstNameColumn1.getCellData(index).toString());
        RunLastTxt.setText(lastNameColu.getCellData(index).toString());
        maraCombox.setValue(marathonNameColumn1.getCellData(index).toString());
        ageFields.setText(ageColumn.getCellData(index).toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addnew_participation(ActionEvent actionEvent) {

        LocalDate date = registerDatepicker.getValue();
        int marathon_id = getidMarathon();
        String PayedTxt = Payed_CheckBox.getText();
        // Insert values into the database
        try {


            Connection con = Db_Connect.Connect_Db();

            if (con != null) {
                PreparedStatement statement = con.prepareStatement(
                        "INSERT INTO participation (marathon_id, runner_id, registration_date, payment_status) " +
                                "VALUES (?, ?, ?, ? )");
                statement.setInt(1,marathon_id);
                statement.setInt(2, runnerId);
                System.out.println(runnerId);
                statement.setDate(3, Date.valueOf(date));
                statement.setString(4, PayedTxt);
                statement.executeUpdate();
                //clearFields();
                    participationTable.setVisible(true);
                    runnerTable.setVisible(false);
                    initialize_Participation();
                    PreparedStatement statement1 = con.prepareStatement(
                            "UPDATE runner SET Payment_status = ? WHERE runner_id = ?");
                    statement1.setString(1, PayedTxt);
                    statement1.setInt(2, runnerId);
                    statement1.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to insert the runner into the database.");
        }

    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInterface(String name) throws Exception {
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
}
