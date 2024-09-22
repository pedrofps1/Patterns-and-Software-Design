public class PlasticBag extends Container{
    private Portion portion;

    public PlasticBag(Portion portion) {
        this.portion=portion;
    }

    public String toString(){
        return "PlasticBag with portion = " + portion.toString();
    }

}
