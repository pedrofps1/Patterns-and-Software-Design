public class YogurtCakeBuilder implements CakeBuilder {
    protected Cake cake = new Cake();

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addCakeLayer() {
        cake.setCakeLayer("Yogurt");
    }

    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Vanilla);
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Red_Berries);
    }

    public void addTopping() {
        cake.setTopping(Topping.Chocolate);
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
