import java.util.Scanner;

public class PortionFactory {
    public static Portion create(String tipo, Temperature t) {
        if (tipo.equals("Beverage")) {
            if (t.equals(Temperature.WARM)) {
                return new Beverage("Milk", t);
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Fruta para FruitJuice: ");
                String fruta = sc.nextLine();
                sc.close();
                return new Beverage("FruitJuice", t, fruta);
            }
        } else if (tipo.equals("Meat")) {
            if (t.equals(Temperature.WARM)) {
                return new Meat("Pork", t);
            } else if (t.equals(Temperature.COLD)) {
                return new Meat("Tuna", t);
            }
        }
        System.out.println("Invalid meal");
        return null;
    }
}
