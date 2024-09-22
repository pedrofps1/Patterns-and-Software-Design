import java.util.Date;

public class TeamLeader extends DecoratorEmployee {
    public TeamLeader(EmployeeInterface name){
        super(name);
    }

    public void start(Date date) {
        super.start(date);
    }

    public void terminate(Date date) {
        super.terminate(date);
    }

    public void work() {
        super.work();
    }
    
    public String getName() {
        return super.getName();
    }

    public void plan() {
        System.out.println("TeamLeader " + super.getName() + " is planning");
    }
}
