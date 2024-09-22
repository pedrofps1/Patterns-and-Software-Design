import java.util.List;
import java.util.ArrayList;

public class ex2 {
    public static void main(String[] args) {
        List<String> List = new ArrayList<>();
        List.add("Veggie Burger");
        List.add("Pasta Carbonara");
        List.add("PLAIN Pizza, no toppings");
        List.add("Sushi nigiri and sashimi");
        List.add("Salad with Tuna");
        List.add("Strawberry ice cream and waffles dessert");

        System.out.println("Can I please get a veggie burger?");
            Chef handler = new SushiChef().setSuccesor(
                                new PastaChef().setSuccesor(
                                    new BurguerChef().setSuccesor(
                                        new PizzaChef().setSuccesor(
                                            new DessertChef()))));  

        for (String str : List) {
            System.out.println("Can I please get a " + str + "?");
            handler.pedido(str);
            System.out.println("\n");
        }
    }
}
