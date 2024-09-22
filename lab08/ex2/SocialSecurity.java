import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {
    private List<Person> securities = new ArrayList<>();
    
    public void regist(Person p){
        securities.add(p);
        System.out.println("Employee " + p.getName() + " registered in Social Security");
    }
}
