import java.util.ArrayList;
import java.util.List;

public class Insurance {
    private List<Person> insurances = new ArrayList<>();
    
    public void regist(Person p){
        insurances.add(p);
        System.out.println("Employee " + p.getName() + " registered in Insurance");    
    }
}
