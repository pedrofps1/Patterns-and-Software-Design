import java.io.File;

public class Test{
    public static void main(String[] args){

        File someFileName = new File("texto.txt");

        ReaderInterface reader0 = new TextReader(someFileName);
        System.out.println(reader0.next());

        ReaderInterface reader1 = new NormalizationFilter(new TextReader(someFileName));
        System.out.println(reader1.next());
        
        ReaderInterface reader2 = new TermFilter(new TextReader(someFileName));
        System.out.println(reader2.next());
 
        ReaderInterface reader3 = new CapitalizationFilter(new TextReader(someFileName));
        System.out.println(reader3.next());

        ReaderInterface reader4 = new VowelFilter(new TextReader(someFileName));
        System.out.println(reader4.next());

        ReaderInterface reader5 = new VowelFilter(new TermFilter(new TextReader(someFileName)));
        System.out.println(reader5.next());

        ReaderInterface reader6 = new CapitalizationFilter(new VowelFilter(new TextReader(someFileName)));
        System.out.println(reader6.next());

        ReaderInterface reader7 = new NormalizationFilter(new CapitalizationFilter(new VowelFilter(new TextReader(someFileName))));
        System.out.println(reader7.next());
    }
}