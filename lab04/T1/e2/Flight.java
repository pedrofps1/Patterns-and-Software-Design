package e2;
import java.util.*;

public class Flight {
    private String code;
    public Airplane plane;
    public Map<Integer,Reservation> reservations = new HashMap<Integer,Reservation>();

    public Flight(String code, Airplane plane) {
        this.code = code;
        this.plane = plane;
    }

    public String getCode() {
        return code;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(code, flight.code) && Objects.equals(plane, flight.plane) && Objects.equals(reservations, flight.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, plane, reservations);
    }
}
