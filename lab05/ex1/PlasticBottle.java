
public class PlasticBottle extends Container{

    private Portion portion;

    public PlasticBottle(Portion portion) {
        this.portion=portion;
    }

    public String toString(){
        return "PlasticBottle with portion = " + portion.toString();
    }
}
