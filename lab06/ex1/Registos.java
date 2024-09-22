import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees
    
    public Registos() {
        empregados = new ArrayList<>();
    }
    
    public void insere(Empregado emp) {
        // Code to insert employee
        for (int i = 0; i < empregados.size(); i++) {
            if(empregados.get(i).equals(emp)){
                System.out.println("Ja registado");
                return;
            }
        }
        empregados.add(emp);
    }
    
    public void remove(int codigo) {
        // Code to remove employee
        for (int i = 0; i < empregados.size(); i++) {
            if(empregados.get(i).codigo() == codigo){
                empregados.remove(empregados.get(i));
                break;
            }
        }
    }
    
    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for (int i = 0; i < empregados.size(); i++) {
            if(empregados.get(i).codigo() == codigo){
                System.out.println("Encontrado!");
                return true;
            }
        }
        System.out.println("Nao encontrado!");
        return false;
    }
    
    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        return empregados;
    }
}