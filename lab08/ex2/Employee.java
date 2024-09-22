
public class Employee {

	private double salary;
	private Person person;
	private BankAccount bank;

	public Employee(Person n, double s) {
		person = n;
		salary = s;
		bank = new BankAccountImpl("PeDeMeia", 0);
	}

	public double getSalary() {
		return salary;
	}

	public BankAccount getBankAccount(){
        return bank;
    }
	public Person getPerson(){
		return person;
	}
}