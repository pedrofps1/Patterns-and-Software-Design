import java.util.Date;

public class TeamMember extends DecoratorEmployee{
    public TeamMember(EmployeeInterface name){
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

    public void colaborate() {
        System.out.println("TeamMember " + super.getName() + " is colaborating");
    }

    public String getName() {
        return super.getName();
    }

}
    
