import java.util.Random;
public class PastaChef extends Chef{
    public void pedido(String s){
        if(s.toLowerCase().contains("pasta")){
            int min = new Random().nextInt(60);
            System.out.println("PastaChef: Starting to cook " + s + ". Out in " + min + " minutes!");
        }
        else{
            System.out.println("PastaChef: I can't do that.");
            if(chef != null){
                chef.pedido(s);
            }
        }
    }
}
