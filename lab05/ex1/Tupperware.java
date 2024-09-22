
public class Tupperware extends Container{
    private Portion portion;

    public Tupperware(Portion portion) {
        this.portion = portion;
    }

    public String toString(){
        return "Tupperware with portion = " + portion.toString();
    }
}
