public class NullEmployee extends Employee{

	protected String name;

	public NullEmployee(String name){
		this.name = name;
	}
	@Override
	public String getName() {
		return "Null pointer Exception! Employee " + name + " not found!";
	}
}