import java.util.Date;

public abstract class DecoratorEmployee implements EmployeeInterface{
    private EmployeeInterface worker;

    public DecoratorEmployee(EmployeeInterface worker){
        this.worker = worker;
    }

    public void start(Date date) {
        this.worker.start(date);;
    }

    public void terminate(Date date) {
        this.worker.terminate(date);
    }

    public void work() {
        this.worker.work();
    }
    
    public String getName(){
        return this.worker.getName();
    }
}
