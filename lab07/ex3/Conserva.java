
public class Conserva extends Produto{
    private String name;
    private double peso;
    
    public Conserva(String name, double peso){
        this.name = name;
        this.peso = peso;
    }

    public double getWeight(){
        return this.peso;
    }

    public void draw(){
        String linha = "Conserva '" + this.name + "' - Weight: " + this.peso;
        System.out.println(sb.toString() + linha);
    }
}
