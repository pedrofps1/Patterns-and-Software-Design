package e2;

import java.util.HashMap;
import java.util.Map;

public class Airplane {

    private Class  classType;
    private int capacity;
    private int numPassengers;

    private int[] seatsTuristica;
    private int[] seatsExecutiva;

    private int rowsTuristica;
    private int rowsExecutiva;

    private int nChairsTuristica;
    private int nChairsExecutiva;
    private int availableSeatsTuristica;
    private int availableSeatsExecutiva;

    public Map<Integer, Character> seats = new HashMap<Integer, Character>();

    
}
