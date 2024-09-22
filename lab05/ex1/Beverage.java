public class Beverage implements Portion {
    private String bev;
    private State estado = State.Liquid;
    private Temperature t;
    private String fruta = null;

    public Beverage(String bev, Temperature t) {
        this.bev = bev;
        this.t = t;
    }

    public Beverage(String bev, Temperature t, String fruta) {
        this.bev = bev;
        this.t = t;
        this.fruta = fruta;
    }

    public Temperature getTemperature() {
        return this.t;
    }

    public State getState() {
        return this.estado;
    }

    public String toString() {
        if (fruta != null) {
            return this.bev + ": " + this.fruta + ", Temperature " + this.t + ", State " + this.estado;
        } else {
            return this.bev + ": Temperature " + this.t + ", State " + this.estado;
        }
    }

}
