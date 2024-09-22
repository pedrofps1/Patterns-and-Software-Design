import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Company {

	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private Insurance insurance = new Insurance();
	private Parking parking = new Parking();
	private SocialSecurity socialSecurity = new SocialSecurity();

	private EmployeeCard employeeCard = new EmployeeCard();

	public void admitEmployee(Person person, double salary) {
		Employee e = new Employee(person, salary);
		emps.add(e);

		socialSecurity.regist(person);

		insurance.regist(person);

		// PARTE DO CARTAO 
		employeeCard.createCard(person);

	//	System.out.println("-- Salary Average is " + avgSalary());

		// autorização caso o salario for superior à media
		if(salary > avgSalary()){
			parking.allow(person);
		} 
		
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	// CALCULO DA MEDIA DE SALARIOS
	public double avgSalary(){
		double total = 0;
		int count = 0;
		double avg = 0;
		for (Employee employee : emps){
			total += employee.getSalary();
			count++;
		}
		avg = total / count;

		return avg;
	}
}