import java.util.Iterator;
import java.util.ListIterator;

public class ex1 {
    public static void main(String[] args) {
        VectorGeneric<String> vec = new VectorGeneric<>();
    
        vec.addElem("bola");
        vec.addElem("baliza");
        vec.addElem("redes");
        vec.addElem("equipa");
        vec.addElem("jogador");
    
        Iterator<String> iter = vec.Iterator();
        ListIterator<String> iter1 = vec.ListIterator();
        ListIterator<String> iter2 = vec.ListIterator(3);
    
        System.out.println("iterator(next)");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    
        System.out.println("\nList iterator(next)");
        while (iter1.hasNext()) {
            System.out.printf("Index %d --> %s\n", iter1.nextIndex(), iter1.next());
        }
    
        System.out.println("backwards(previous)");
        while (iter1.hasPrevious()) {
            System.out.printf("Index %d --> %s\n", iter1.previousIndex() + 1, iter1.previous());
        }
    
        System.out.println("\nList iterator index 4(next starting in index 4)");
        while (iter2.hasNext()) {
            System.out.printf("Index %d --> %s\n", iter2.nextIndex(), iter2.next());
        }
    }
    
}
