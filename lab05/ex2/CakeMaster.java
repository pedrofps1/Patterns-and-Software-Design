public class CakeMaster {
    private CakeBuilder builder;

    public void createCake(String m) {
        this.builder.createCake();
        this.builder.addMessage(m);
    }

    public void createCake(Shape shape, int layers, String m) {
        this.builder.createCake();
        this.builder.setCakeShape(shape);
        this.builder.getCake().setNumCakeLayers(layers);
        this.builder.addMessage(m);
    }

    public void createCake(int layers, String m) {
        this.builder.createCake();
        this.builder.getCake().setNumCakeLayers(layers);
        this.builder.addMessage(m);
    }

    public void setCakeBuilder(CakeBuilder builder) {
        this.builder = builder;
    }

    public Cake getCake() {
        return this.builder.getCake();
    }
}