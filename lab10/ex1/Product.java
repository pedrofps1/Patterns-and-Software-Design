import java.util.ArrayList;
import java.util.List;

public class Product {
    private static int count = 0;
    private int code;
    private String description;
    private double price;
    private StateProduct state;
    private double duration = 0;
    private List<Observer> observers = new ArrayList<Observer>();
    
    public Product(String description, double price){
        this.code = ++count;
        this.description=description;
        this.price=price;
        state=StateProduct.STOCK;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer){
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    public StateProduct getState() {
        return this.state;
    }

    public void setState(StateProduct state){
        this.state=state;
        if(this.state==StateProduct.AUCTION){
            this.duration = System.currentTimeMillis();
        }
        else{
            this.duration = System.currentTimeMillis() - this.duration;
            System.out.println("Product was in auction during : + " + this.duration);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double bidAmmount) {
        this.price = bidAmmount;
        notify(true);
    }

    private void notify(boolean newBid) {
        for (Observer observer : observers) {
            observer.update(this, newBid);
        }
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }

    public int getCode() {
        return this.code;
    }




    // public void attach(Observer observer){
    //     observers.add(observer);
    // }

    // public void remove(Observer observer){
    //     if(observers.contains(observer)){
    //         observers.remove(observer);
    //     }
    // }

    // @Override
    // public void notify(){
    //     for(Observer observer: observers){
    //         observer.update(this);
    //     }
    // }

    // public void setState(State state){
    //     this.state=state;
    //     if(this.state==State.AUCTION){
    //         this.duration = System.nanoTime();
    //     }
    //     else{
    //         this.duration = System.nanoTime() - this.duration;
    //         System.out.println("Product was in auction during : + " + this.duration);
    //     }
    // }

    // public State getState(){
    //     return this.state;
    // }

    // public void setPrice(double amount) {
    //     this.price = amount;
    // }

    // public double getPrice() {
    //     return this.price;
    // }

    // public int getCode(){
    //     return this.code;
    // }

    // public String getDescription(){
    //     return this.description;
    // }

    // public String toString(){
    //     return this.code + " description: " + this.getDescription() + ", price: " + this.getPrice();
    // }
}
