import java.text.Normalizer;
import java.text.Normalizer.Form;

public class NormalizationFilter extends DecoratorReader{

    public NormalizationFilter(ReaderInterface reader){
        super(reader);
    }

    public boolean hasNext(){
        return super.hasNext();
    }

    public String next(){
        return Normalizer.normalize(super.next(), Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("[\\p{Punct}\\p{IsPunctuation}]", "");
    }
}
