import java.util.ArrayList;

public class Manager extends Observer{
    private String name;
    protected ArrayList<Product> stock;
    protected ArrayList<Product> sales;

    public Manager(String name){
        this.name = name;
        this.products = new ArrayList<Product>();
        this.stock = new ArrayList<Product>();
        this.sales = new ArrayList<Product>();
    }


    public void regist(Product p) {
        if(p.getState() == StateProduct.AUCTION){
            products.add(p);
        }
        else if(p.getState() == StateProduct.STOCK){
            stock.add(p);
        }
        else{
            sales.add(p);
        }
    }

    public void update(Product p, boolean state_change){
        if(state_change == true){
            System.out.println("product has new bid: " + p.getCode() + " price: " + p.getPrice());
        }
        else{
            if(p.getState() == StateProduct.SALES){
                System.out.println("product sold: " + p.getPrice());
                products.remove(p);
                sales.add(p);
            }
        }

    }

    
}
