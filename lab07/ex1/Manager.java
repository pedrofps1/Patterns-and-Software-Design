import java.util.Date;

public class Manager extends DecoratorEmployee{
    public Manager(EmployeeInterface name){
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

    public String getName(){
        return super.getName();
    }

    public void manage() {
        System.out.println("Manager " + super.getName() + " is managing");
    }

}
