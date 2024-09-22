import java.util.ArrayList;
import java.util.List;

public class CapitalizationFilter extends DecoratorReader{

    public CapitalizationFilter(ReaderInterface reader){
        super(reader);

    }
    public boolean hasNext() {
       return super.hasNext();
    }

    public String next(){
        List<Character> listaCaracteres = new ArrayList<Character>();
        
        String str = super.next();

        for (int i = 0 ; i < str.length() ; i++) {
            char caractere = str.charAt(i);
            listaCaracteres.add(caractere);
        }
     //   System.out.print(listaCaracteres);

        //Coloca a primeira letra em maiúsculo
        if(!listaCaracteres.isEmpty()){
            for (int i = 0 ; i < listaCaracteres.size();  i++) {
                char c = listaCaracteres.get(i);
                if(Character.isLetter(c)){
                    char primeiroCharMaiusculo = Character.toUpperCase(c);
                    listaCaracteres.set(i, primeiroCharMaiusculo);
                    break;
                }
            }
        }
        
        // Coloca a última letra em maiúsculo
        if (listaCaracteres.size() > 1) {
            for (int i = listaCaracteres.size() - 1; i >= 0; i--) {
                char c = listaCaracteres.get(i);
                if (Character.isLetter(c)) {
                    char ultimoCharMaiusculo = Character.toUpperCase(c);
                    listaCaracteres.set(i, ultimoCharMaiusculo);
                    break;
                }
            }
        }

        // Concatena os caracteres da lista para formar o texto final
        StringBuilder sb = new StringBuilder();
        for (char c : listaCaracteres) {
            sb.append(c);
        }

        String textoFinal = sb.toString();

        return textoFinal;
        }
        
}