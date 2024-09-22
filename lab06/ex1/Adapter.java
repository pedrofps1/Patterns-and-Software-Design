import javax.sound.midi.SysexMessage;

public class Adapter {
    private Database database;
    private Registos registos;

    public Adapter(){
        this.database = new Database();
        this.registos = new Registos();
    }

    public boolean addEmployee(Employee emp){
        return this.database.addEmployee(emp);
    }

    public void addEmpregado(Empregado emp){
        this.registos.insere(emp);
    }

    public void removeEmpregado(int emp_num){
        this.database.deleteEmployee(emp_num);
        this.registos.remove(emp_num);
    }

    public boolean exists(int emp_num){
        if(this.registos.isEmpregado(emp_num)){
            System.out.println("Empregado existe");
            return true;
        }
        else{
            for(Employee emp : this.database.getAllEmployees()) {
                if(emp.getEmpNum() == emp_num){
                    System.out.println("Employee existe");
                    return true;
                }
            }
        }
        return false;
    }

    public void print(){
        for(Employee emp : this.database.getAllEmployees()) {
            System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getEmpNum());
        }
        for(Empregado emp : this.registos.listaDeEmpregados()) {
            System.out.println(emp.nome() + " " + emp.apelido() + " " + emp.codigo() + " " + emp.salario());
        }
    }
}
