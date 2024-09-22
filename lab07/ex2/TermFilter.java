public class TermFilter extends DecoratorReader{

    private int nWords = 0;
    public TermFilter(ReaderInterface reader){
        super(reader);
    }
    public boolean hasNext() {
       return super.hasNext();
    }

    public String next(){
        String words[] = super.next().split("\\s+");
        this.nWords++;
        return words[nWords];
    }
}