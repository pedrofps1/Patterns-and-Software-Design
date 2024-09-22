import java.util.Collection;

public class RemoveCommand<E> extends Command<E> {
    public RemoveCommand(Collection<E> collection, E element){
        super(collection, element);
    }
    
    @Override
    public void execute(){
        collection.remove(element);
    }

    @Override
    public void undo(){
        collection.add(element);
    }
}
