import java.util.Collection;

public abstract class Command<E> {
    protected Collection<E> collection;
    protected E element;
    
    public Command(Collection<E> collection, E element){
        this.collection = collection;
        this.element=element;
    }

    public abstract void execute();
    public abstract void undo();
}
