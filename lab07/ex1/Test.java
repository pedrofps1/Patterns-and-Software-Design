import java.util.Date;

public class Test {

    public static void main(String[] args) {
        EmployeeInterface employee1 = new Employee("Sara"); 
        EmployeeInterface employee2 = new Employee("Pedro"); 

        employee1.start(new Date());
        employee2.start(new Date());

        employee1.work();
        employee2.work();

        employee1.terminate(new Date());
        employee2.terminate(new Date());

        TeamMember tm = new TeamMember(new Employee("Joao"));
        tm.start(new Date());
        tm.work();

        TeamLeader tl = new TeamLeader(employee1);
        tl.work();

        Manager manager = new Manager(employee2);
        manager.work();
        manager.manage();

        Manager manager2 = new Manager(new Employee("Ana"));
        manager2.work();

        TeamMember tm2 = new TeamMember(new TeamLeader(new Employee("Lara")));
        tm2.start(new Date());
        tm2.work();
        tm2.colaborate();
        

        // TeamLeader leader1 = new TeamLeader(new Employee("Ana"));
        // TeamMember member1 = new TeamMember(new Employee("Joana"));
        // Manager man1 = new Manager(new TeamMember(new Employee("Pedro")));
        // Manager man2 = new Manager(new TeamLeader(new TeamMember(new Employee("António"))));

        // EmployeeInterface[] emps = {employee , man1 , man2 , leader1, member1};

        // for(EmployeeInterface i : emps){
        //     i.work();
        //     if(i instanceof TeamLeader){
        //         ((TeamLeader) i).plan();
        //     }
        //     if(i instanceof TeamMember){
        //         ((TeamMember) i).colaborate();
        //     }
        //     if(i instanceof TeamLeader){
        //         ((Manager) i).manage();
        //     }
        // }
        // leader1.work();
        // man1.manage();
        // // man2.terminate(new Date(23,12,12));
        

    }
}