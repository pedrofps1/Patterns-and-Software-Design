import java.util.List;

public class Main {
    public static void main (String[] args) {
        Empregado e1 = new Empregado("Pedro", "Santos", 12345, 1000);
        Empregado e2 = new Empregado("Sara", "Silva", 88888, 2000);
        Empregado e3 = new Empregado("Jose", "Martins", 12121, 4250);
        Empregado e4 = new Empregado("Ana", "Dias", 55555, 555);

        Registos reg = new Registos();
        reg.insere(e1);
        reg.insere(e2);
        reg.insere(e3);
        reg.insere(e4);
        reg.isEmpregado(12345);
        reg.isEmpregado(11111);
        reg.remove(88888);

        List<Empregado> emp = reg.listaDeEmpregados();
        for (Empregado empregado : emp) {
            System.out.println(empregado.nome() + " " + empregado.apelido() + " " + + empregado.codigo() + " " + empregado.salario());
        }
        System.out.println();



        Employee emp1 = new Employee("Diogo", 123, 3500);
        Employee emp2 = new Employee("Pedro", 456, 2000);
        Employee emp3 = new Employee("Sara", 789, 980);

        Database db = new Database();
        db.addEmployee(emp1);
        db.addEmployee(emp2);
        db.addEmployee(emp3);
        db.deleteEmployee(123);
        for (Employee e: db.getAllEmployees()) {
            System.out.println(e.getName() + " " + e.getEmpNum() + " " + e.getSalary());
        }
        System.out.println();



        Adapter adaptee = new Adapter();
        adaptee.addEmployee(emp1);
        Empregado e5 = new Empregado("Joao", "Martins", 22222, 750);
        adaptee.addEmpregado(e5);
        adaptee.removeEmpregado(12345);
        adaptee.print();
        adaptee.exists(e5.codigo());
        adaptee.exists(e1.codigo());
    }
}
