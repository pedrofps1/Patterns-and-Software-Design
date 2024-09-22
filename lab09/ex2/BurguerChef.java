import java.util.Random;

public class BurguerChef extends Chef{
    public void pedido(String s){
        if(s.toLowerCase().contains("burger")){
            int min = new Random().nextInt(60);
            System.out.println("BurgerChef: Starting to cook " + s + ". Out in " + min + " minutes!");
        }
        else{
            System.out.println("BurgerChef: I can't do that.");
            if(chef != null){
                chef.pedido(s);
            }
        }
    }
}
