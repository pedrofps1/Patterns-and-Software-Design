import java.util.Vector;

public class Database { // Data elements
    private Vector<Employee> employees; // Stores the employees
    
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).equals(employee)){
                System.out.println("Ja registado");
                return false;
            }
        }
        employees.add(employee);
        return true;
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getEmpNum() == emp_num){
                employees.remove(employees.get(i));
                System.out.println("Encontrado!");
                break;
            }
        }
    }
    
    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        Employee[] emp = new Employee[employees.size()];
        return employees.toArray(emp);
    }
}