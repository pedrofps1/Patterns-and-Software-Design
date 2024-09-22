import java.util.ArrayList;
import java.util.List;

public class ex3 {
    public static void main(String[] args) {
        List<Integer> add = new ArrayList<>();
        System.out.println(add);
        AddCommand<Integer> addcommand = new AddCommand<>(add, 1);
        addcommand.execute();
        System.out.println(add); 
        addcommand.undo();
        System.out.println(add); 

        System.out.println();

        List<Integer> remove = new ArrayList<>();
        remove.add(1);
        System.out.println(remove);
        RemoveCommand<Integer> removecommand = new RemoveCommand<>(remove, 1);
        removecommand.execute();
        System.out.println(remove);
        removecommand.undo();
        System.out.println(remove);
    }
}