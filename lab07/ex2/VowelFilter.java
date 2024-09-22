
public class VowelFilter extends DecoratorReader{
    public VowelFilter(ReaderInterface reader){
        super(reader);
    }

    public boolean hasNext(){
        return super.hasNext();
    }

    public String next(){
        String str = super.next();
        String txt_semvogais = "";

        for (int i = 0 ; i < str.length() ; i++) {
            str = str.replaceAll("[AEIOUaeiouÁÉÍÓÚáéíóúÂÊÎÔÛâêîôûÀÈÌÒÙàèìòùÃãÕõ]" , "");
            
        }
        txt_semvogais += str + "\n";
        return txt_semvogais;
    }
}