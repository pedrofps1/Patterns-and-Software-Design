
public class Phone {
    private String cpu;
    private double price;
    private int mem;
    private String camera;


    public Phone(String cpu, double price, int mem, String camera) {
        this.cpu = cpu;
        this.price = price;
        this.mem = mem;
        this.camera = camera;
    }

    public String getCpu() {
        return this.cpu;
    }

    public double getPrice() {
        return this.price;
    }

    public int getMem() {
        return this.mem;
    }
    public String getCamera() {
        return this.camera;
    }   
}
