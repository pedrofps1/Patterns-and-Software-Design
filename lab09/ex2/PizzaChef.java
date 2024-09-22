import java.util.Random;
public class PizzaChef extends Chef{
    public void pedido(String s){
        if(s.toLowerCase().contains("pizza")){
            int min = new Random().nextInt(60);
            System.out.println("PizzaChef: Starting to cook " + s + ". Out in " + min + " minutes!");
        }
        else{
            System.out.println("PizzaChef: I can't do that.");
            if(chef != null){
                chef.pedido(s);
            }
        }
    }
}
