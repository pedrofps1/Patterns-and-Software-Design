
public class TermicBottle extends Container{

    private Portion portion;

    public TermicBottle(Portion portion) {
        this.portion=portion;
    }

    public String toString(){
        return "TermicBottle with portion = " + portion.toString();
    }
}
