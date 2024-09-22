
public class Bebida extends Produto{
    private String name;
    private double peso;
    
    public Bebida(String name, double peso){
        this.name = name;
        this.peso = peso;
    }

    public double getWeight(){
        return this.peso;
    }

    public void draw(){
        String linha = "Bebida '" + this.name + "' - Weight: " + this.peso;
        System.out.println(sb.toString() + linha);
    }
}
