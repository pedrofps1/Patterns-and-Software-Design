import java.util.Random;
public class DessertChef extends Chef{
    public void pedido(String s){
        if(s.toLowerCase().contains("dessert")){
            int min = new Random().nextInt(60);
            System.out.println("DessertChef: Starting to cook " + s + ". Out in " + min + " minutes!");
        }
        else{
            System.out.println("DessertChef: I can't do that.");
            if(chef != null){
                chef.pedido(s);
            }
        }
    }
}
