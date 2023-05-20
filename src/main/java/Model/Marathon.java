package Model;


import javafx.beans.property.*;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDate;

public class Marathon {
    private final IntegerProperty marathonId;
    private final StringProperty name;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty startLocation;
    private final StringProperty finishLocation;
    private final DoubleProperty distance;



    public Marathon(int marathonId, String name, LocalDate date, String startLocation, String finishLocation, double distance) {
        this.marathonId = new SimpleIntegerProperty(marathonId);
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleObjectProperty<>(date);
        this.startLocation = new SimpleStringProperty(startLocation);
        this.finishLocation = new SimpleStringProperty(finishLocation);
        this.distance = new SimpleDoubleProperty(distance);
    }

    public Marathon(IntegerProperty marathonId, String name, LocalDate date, String startLocation, String finishLocation, double distance) {
        this.marathonId = marathonId;
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleObjectProperty<>(date);
        this.startLocation = new SimpleStringProperty(startLocation);
        this.finishLocation = new SimpleStringProperty(finishLocation);
        this.distance = new SimpleDoubleProperty(distance);
    }

    public int getMarathonId() {
        return marathonId.get();
    }

    public IntegerProperty marathonIdProperty() {
        return marathonId;
    }

    public void setMarathonId(int marathonId) {
        this.marathonId.set(marathonId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getStartLocation() {
        return startLocation.get();
    }

    public StringProperty startLocationProperty() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation.set(startLocation);
    }

    public String getFinishLocation() {
        return finishLocation.get();
    }

    public StringProperty finishLocationProperty() {
        return finishLocation;
    }

    public void setFinishLocation(String finishLocation) {
        this.finishLocation.set(finishLocation);
    }

    public double getDistance() {
        return distance.get();
    }

    public DoubleProperty distanceProperty() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance.set(distance);
    }



}


