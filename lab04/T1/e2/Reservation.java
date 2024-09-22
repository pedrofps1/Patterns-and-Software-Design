package e2;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private Class classType;
    private int passengers;

    public Reservation(Class classType, int passengers) {
        this.classType = classType;
        this.passengers = passengers;
    }

    public Class getClassType() {
        return classType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return passengers == that.passengers && Objects.equals(classType, that.classType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classType, passengers);
    }
}
