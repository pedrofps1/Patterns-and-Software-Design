import java.util.ArrayList;
import java.util.List;

public class EmployeeCard {

    private static int CardNum = 000;

    private List<Person> cards = new ArrayList<>();
 
    public void createCard(Person p ){
        cards.add(p);
        CardNum++;
        System.out.println("Employee " + p.getName() + " has card created with Number: " + CardNum);    
    }
}
