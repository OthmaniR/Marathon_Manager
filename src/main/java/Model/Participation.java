package Model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Participation {
    private final IntegerProperty participation_id;
    private final StringProperty marathon_id;
    private final StringProperty runner_id;
    private final ObjectProperty<LocalDate>  Registration_date;
    private final BooleanProperty isConfirmed;
    private final BooleanProperty isAbandoned;
    private final BooleanProperty payment_status;

    public Participation(int participation_id, String marathon_id, String runner_id, LocalDate registration_date, boolean isConfirmed, boolean isAbandoned, boolean payment_status) {
        this.participation_id = new SimpleIntegerProperty(participation_id);
        this.marathon_id = new SimpleStringProperty(marathon_id);
        this.runner_id = new SimpleStringProperty(runner_id);
        this.Registration_date = new SimpleObjectProperty<>(registration_date);
        this.isConfirmed = new SimpleBooleanProperty(isConfirmed);
        this.isAbandoned = new SimpleBooleanProperty(isAbandoned);
        this.payment_status = new SimpleBooleanProperty(payment_status);
    }

    public Participation(IntegerProperty participation_id, String marathon_id, String runner_id, LocalDate registration_date, boolean isConfirmed, boolean isAbandoned, boolean payment_status) {
        this.participation_id = participation_id;
        this.marathon_id = new SimpleStringProperty(marathon_id);
        this.runner_id = new SimpleStringProperty(runner_id);
        this.Registration_date = new SimpleObjectProperty<>(registration_date);
        this.isConfirmed = new SimpleBooleanProperty(isConfirmed);
        this.isAbandoned = new SimpleBooleanProperty(isAbandoned);
        this.payment_status = new SimpleBooleanProperty(payment_status);
    }


    public int getParticipation_id() {
        return participation_id.get();
    }

    public IntegerProperty participation_idProperty() {
        return participation_id;
    }

    public void setParticipation_id(int participation_id) {
        this.participation_id.set(participation_id);
    }

    public String getMarathon_id() {
        return marathon_id.get();
    }

    public StringProperty marathon_idProperty() {
        return marathon_id;
    }

    public void setMarathon_id(String marathon_id) {
        this.marathon_id.set(marathon_id);
    }

    public String getRunner_id() {
        return runner_id.get();
    }

    public StringProperty runner_idProperty() {
        return runner_id;
    }

    public void setRunner_id(String runner_id) {
        this.runner_id.set(runner_id);
    }

    public LocalDate getRegistration_date() {
        return Registration_date.get();
    }

    public ObjectProperty<LocalDate> registration_dateProperty() {
        return Registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.Registration_date.set(registration_date);
    }

    public boolean isIsConfirmed() {
        return isConfirmed.get();
    }

    public BooleanProperty isConfirmedProperty() {
        return isConfirmed;
    }

    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed.set(isConfirmed);
    }

    public boolean isIsAbandoned() {
        return isAbandoned.get();
    }

    public BooleanProperty isAbandonedProperty() {
        return isAbandoned;
    }

    public void setIsAbandoned(boolean isAbandoned) {
        this.isAbandoned.set(isAbandoned);
    }

    public boolean isPayment_status() {
        return payment_status.get();
    }

    public BooleanProperty payment_statusProperty() {
        return payment_status;
    }

    public void setPayment_status(boolean payment_status) {
        this.payment_status.set(payment_status);
    }
}
