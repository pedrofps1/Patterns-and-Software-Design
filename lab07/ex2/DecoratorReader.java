public abstract class DecoratorReader implements ReaderInterface{
    protected ReaderInterface reader;

    public DecoratorReader(ReaderInterface reader){
        this.reader = reader;
    }

    public boolean hasNext(){
        return this.reader.hasNext();
    }

    public String next(){
        return this.reader.next();
    }
}
