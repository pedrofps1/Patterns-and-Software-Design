public class ChocolateCakeBuilder implements CakeBuilder {
    protected Cake cake = new Cake();

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addCakeLayer() {
        cake.setCakeLayer("Soft chocolate");
    }

    public void addCreamLayer() {
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        cake.setTopping(Topping.Fruit);
    }

    public void addMessage(String m) {
        cake.setMessage(m);
    }

    public void createCake() {
        addCakeLayer();
        addTopLayer();
        addTopping();
    }

    public Cake getCake() {
        return cake;
    }
}