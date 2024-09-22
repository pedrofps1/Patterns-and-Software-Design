import java.util.Collection;

public class AddCommand<E> extends Command<E>{
    public AddCommand(Collection<E> collection, E element){
        super(collection, element);
    }
    
    @Override
    public void execute(){
        collection.add(element);
    }

    @Override
    public void undo(){
        collection.remove(element);
    }
}
