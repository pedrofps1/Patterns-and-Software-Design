import java.util.ArrayList;

public abstract class Observer {
    protected ArrayList<Product> products;

    public abstract void update(Product p, boolean state_change);
}
