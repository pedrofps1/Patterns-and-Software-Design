import java.util.Random;
public class SushiChef extends Chef{
    public void pedido(String s){
        if(s.toLowerCase().contains("sushi")){
            int min = new Random().nextInt(60);
            System.out.println("SushiChef: Starting to cook " + s + ". Out in " + min + " minutes!");
        }
        else{
            System.out.println("SushiChef: I can't do that.");
            if(chef != null){
                chef.pedido(s);
            }
        }
    }
}