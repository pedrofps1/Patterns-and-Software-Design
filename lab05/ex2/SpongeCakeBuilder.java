public class SpongeCakeBuilder implements CakeBuilder {
    protected Cake cake = new Cake();

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addCakeLayer() {
        cake.setCakeLayer("Sponge");
    }

    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Red_Berries);
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
        addCreamLayer();
        addTopLayer();
        addTopping();
    }

    public Cake getCake() {
        return cake;
    }
}