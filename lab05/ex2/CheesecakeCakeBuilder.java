public class CheesecakeCakeBuilder implements CakeBuilder {
    protected Cake cake = new Cake();

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addCakeLayer() {
        cake.setCakeLayer("Cheesecake");
    }

    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Cheese);
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Strawberry);
    }

    public void addTopping() {
        cake.setTopping(Topping.PassionFruit);
    }

    public void addMessage(String m) {
        cake.setMessage(m);
    }

    public void createCake() {
        addCakeLayer();
        addTopLayer();
        addCreamLayer();
        addTopping();
    }

    public Cake getCake() {
        return cake;
    }
}