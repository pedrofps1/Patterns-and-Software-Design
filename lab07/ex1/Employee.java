import java.util.Date;

public class Employee implements EmployeeInterface{
    String name;
    Date start, end;

    public Employee(String name){
        this.name = name;
    }

    public void start(Date date) {
        this.start = date;
        System.out.println("Date that Employee " + this.name + " started working: " + this.start);
    }

    public void terminate(Date date) {
        this.end = date;
        System.out.println("Date that Employee " + this.name + " stopped working: " + this.end);
    }

    public void work() {
        System.out.println("Employee " + this.name + " is working");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
