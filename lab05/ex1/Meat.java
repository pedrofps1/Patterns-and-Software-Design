public class Meat implements Portion{
    private String m;
    private State estado = State.Solid;
    private Temperature t;

    public Meat(String m, Temperature t) {
        this.m = m;
        this.t = t;
    }

    public Temperature getTemperature() {
        return this.t;    
    }

    public State getState() {
        return this.estado;
    }

    public String toString(){
        String str = this.m + ": Temperature " + this.t + ", State " + this.estado;
        return str;
    }
}
