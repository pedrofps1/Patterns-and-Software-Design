import java.util.ArrayList;

import java.util.List;
import java.util.ArrayList;

public class Caixa extends Produto {
    private List<Produto> products = new ArrayList<>();
    private String name;
    private double pesoCaixa;
    private double pesoTotal;
    
    public Caixa(String name, int pesoCaixa){
        this.name = name;
        this.pesoCaixa = pesoCaixa;
    }

    public void add(Produto p){
        products.add(p);
    }

    public double getWeight(){
        this.pesoTotal = this.pesoCaixa;
        
        for(Produto p : products){
            this.pesoTotal += p.getWeight();
        }

        return this.pesoTotal;
    }

    public void draw(){
        String linha = "* Caixa '" + this.name + "' [ Weight: " + this.pesoCaixa + " ; Total: " + getWeight() + "]"; 
        System.out.println(sb.toString() + linha);
        sb.append("   ");
        for(Produto p : products){
            p.draw();
        }
        sb.setLength(sb.length()-3);
    }
}
