import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Person> parkings = new ArrayList<>();

    public void allow(Person p){
        parkings.add(p);
        System.out.println("Employee " + p.getName() + " is allowed to use the park");
    }
    
}
