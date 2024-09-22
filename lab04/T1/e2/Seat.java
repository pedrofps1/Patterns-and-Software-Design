package e2;
public class Seat {
    private String row;
    private int number;
    private boolean isAvailable;

    public Seat(String row, int number) {
        this.row = row;
        this.number = number;
        this.isAvailable = true;
    }

    public String getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        isAvailable = false;
    }

    public void unbook() {
        isAvailable = true;
    }
}
