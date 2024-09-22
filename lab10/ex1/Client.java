import java.util.ArrayList;

public class Client extends Observer{
    private String name;

    public Client(String name) {
        this.name = name;
        this.products = new ArrayList<Product>();
    }

    public void update(Product p, boolean state_change) {
        System.out.println(this.getName() + ": " + p.toString());
    }

    private String getName() {
        return this.name;
    }

    public void bid(Product prod, double amount){
        if(!this.products.contains(prod)){
            if(prod.getState() == StateProduct.AUCTION){
                prod.attach(this);
                this.products.add(prod);
            }
            else{
                System.out.println("not in auction");
                return;
            }
        }
        if(amount < prod.getPrice()){
            System.out.println("too low");
            return;
        }
        prod.setPrice(amount);
    }    
}
