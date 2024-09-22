import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.HashMap;

public class SoupSolver {
  private List<String> horizontal;
  private List<String> vertical;
  private Map<String, ArrayList<Integer>> diagonalRightLeft;
  private Map<String, ArrayList<Integer>> diagonalLeftRight;
  private Map<String, String> KeyWords;
  private char[][] soupOutput;
  
  SoupSolver(File f) throws FileNotFoundException{
    // inicialização
    horizontal = new ArrayList<String>();
    vertical = new ArrayList<String>();
    diagonalRightLeft = new HashMap<String, ArrayList<Integer>>();  // string e arrayList com 2 inteiros, "line" e "col" que dizem onde começa
    diagonalLeftRight = new HashMap<String, ArrayList<Integer>>();  // string e arrayList com 2 inteiros, "line" e "col" que dizem onde começa
    KeyWords = new HashMap<String, String>();
    Scanner sc = new Scanner(f);
    soupToData(sc);
  }

  SoupSolver(String soupString){
    // inicialização
    horizontal = new ArrayList<String>();
    vertical = new ArrayList<String>();
    diagonalRightLeft = new HashMap<String, ArrayList<Integer>>();  // string e arrayList com 2 inteiros, "line" e "col" que dizem onde começa
    diagonalLeftRight = new HashMap<String, ArrayList<Integer>>();  // string e arrayList com 2 inteiros, "line" e "col" que dizem onde começa
    KeyWords = new HashMap<String, String>();
    Scanner sc = new Scanner(soupString);
    soupToData(sc);
  }

  private void soupToData(Scanner sc){
    String pat;
    int expectedSize = 3;                                           // VALIDAÇÃO (palavra tem de ter no mínimo 3 carateres.. Logo, a sopa de letras também)
    
    sc.useDelimiter("\n");
    if (sc.hasNext("\\p{IsUppercase}{3,40}")) {
      horizontal.add(sc.next());                                    // primeira palavra
      expectedSize = horizontal.get(0).length();                    // respetivo tamanho é o tamanho esperado
      pat = String.format("\\p{IsUppercase}{%d}", expectedSize);

      while (sc.hasNext(pat)) {                                     // adicionar resto das palavras da sopa de letras
        horizontal.add(sc.next());
      }
    }

    // VALIDAÇÃO
    if(horizontal.size()!=expectedSize || expectedSize<3 || expectedSize>40){
      sc.close();
      throw new IllegalArgumentException("Sopa de letras inválida");
    }

    // Depois das palavras da sopa de letras vem a lista de palavras para procurar na sopa de letras
    String input;
    sc.useDelimiter("\n| |,|;");
    pat = "\\p{IsUppercase}*\\p{IsLowercase}+\\p{IsAlphabetic}*";
    outer:
    while (sc.hasNext(pat)) {
      input = sc.next();
      // VALIDAÇÃO: palavra length minimo e máximo
      if(input.length()<3 || input.length()>expectedSize){
        sc.close();
        throw new IllegalArgumentException(String.format("As palavras têm de ter no mínimo 3 letras e no máximo %d (valor máximo calculado de acordo com a sopa de letras atual);Palavra Errada: %s",expectedSize,input));
      }
      // VALIDAÇÃO: Nos casos em que as listas de palavras conatém palavras com partes iguais deve ser considerada apenas a maior
      for(String word : KeyWords.keySet()){
        if(input.contains(word)){
          KeyWords.remove(word);
          break;
        }else if(word.contains(input))
          break outer;
      }
      KeyWords.put(input.toLowerCase(), "");
    }

    if(sc.hasNext()){
      if((input=sc.next()).isBlank()){
        sc.close();
        throw new IllegalArgumentException("Na lista de palavras o ficheiro não pode conter linhas vazias");
      }else{
        sc.close();
        throw new IllegalArgumentException(String.format("Na lista, as palavras podem ser compostas só por letras minúsculas, ou misturadas (minúsculas e maiúsculas); Palavra Errada: %s",input));
      }
    }

    sc.close();
    
    // Gerar palavras verticais e guardá-las
    for(int i=0; i<expectedSize;i++){
      input="";
      for(int j=0; j<expectedSize;j++){
        input+= horizontal.get(j).charAt(i);
      }
      vertical.add(input);
    }
    
    // Gerar palavras diagonais e guardá-las
    // diagonais para a direita
    for(int c = expectedSize - 3; c > -1; c--){
      input="";
      ArrayList<Integer> positions = new ArrayList<Integer>();  // posição inicial da palavra em questao
      positions.add(0);                                         // linha
      positions.add(c);                                         // coluna
      for(int l = 0,currentC = c; currentC < expectedSize && l<expectedSize; l++,currentC++){
        input+=horizontal.get(l).charAt(currentC);
      }
      diagonalLeftRight.put(input, positions);
    }
    for(int l = expectedSize - 3; l > 0; l--){
      input="";
      ArrayList<Integer> positions = new ArrayList<Integer>();  // posição inicial da palavra em questao
      positions.add(l);                                         // linha
      positions.add(0);                                         // coluna
      for(int c = 0,currentL = l; currentL < expectedSize && c<expectedSize; c++,currentL++){
        input+=horizontal.get(currentL).charAt(c);
      }
      diagonalLeftRight.put(input, positions);
    }

    // diagonais para a esquerda
    for(int c = expectedSize - 2; c > 1; c--){
      input="";
      ArrayList<Integer> positions = new ArrayList<Integer>();  // posição inicial da palavra em questao
      positions.add(0);                                         // linha
      positions.add(c);                                         // coluna
      for(int l = 0,currentC = c; currentC > -1 && l<expectedSize; l++,currentC--){
        input+=horizontal.get(l).charAt(currentC);
      }
      diagonalRightLeft.put(input, positions);
    }
    for(int l = expectedSize - 3; l >= 0; l--){
      input="";
      ArrayList<Integer> positions = new ArrayList<Integer>();  // posição inicial da palavra em questao
      positions.add(l);                                         // linha
      positions.add(expectedSize - 1);                          // coluna
      for(int c = expectedSize - 1,currentL = l; currentL < expectedSize && c > -1; c--,currentL++){
        input+=horizontal.get(currentL).charAt(c);
      }
      diagonalRightLeft.put(input, positions);
    }
    
    soupOutput = new char[expectedSize][expectedSize];
    for (int i = 0; i < expectedSize; i++)
    {
      for (int j = 0; j < expectedSize; j++)
      {
        soupOutput[i][j] = '.';
      }
    }
  }

  public void setHorizontal(List<String> horizontal) {
      this.horizontal = horizontal;
  }
  public void setVertical(List<String> vertical) {
      this.vertical = vertical;
  }
  public void setDiagonalLeftRight(Map<String, ArrayList<Integer>> diagonalLeftRight) {
      this.diagonalLeftRight = diagonalLeftRight;
  }
  public void setDiagonalRightLeft(Map<String, ArrayList<Integer>> diagonalRightLeft) {
      this.diagonalRightLeft = diagonalRightLeft;
  }

  public void setSoupOutput(char[][] soupOutput) {
      this.soupOutput = soupOutput;
  }
  public void setKeyWords(Map<String, String> keyWords) {
      this.KeyWords = keyWords;
  }
  


  public List<String> getHorizontal() {
      return horizontal;
  }
  public List<String> getVertical() {
      return vertical;
  }
  public Map<String, ArrayList<Integer>> getDiagonalLeftRight() {
      return diagonalLeftRight;
  }
  public Map<String, ArrayList<Integer>> getDiagonalRightLeft() {
      return diagonalRightLeft;
  }
  public char[][] getSoupOutput() {
      return soupOutput;
  }
  public Map<String, String> getKeyWords() {
      return KeyWords;
  }


  public void solve()
  {
    int i, j, line, col, idx, soupLength = horizontal.size();
    
    // Procurar horizontal:
    for (i = 0; i < soupLength; i++)
    {
      for (Map.Entry<String,String> entry : KeyWords.entrySet())
      {
        String key = entry.getKey();
        String upperCaseKey = key.toUpperCase();
        String value = entry.getValue(); 

        if (horizontal.get(i).contains(upperCaseKey))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(upperCaseKey, horizontal.get(i));
          entry.setValue(String.format("%2d    %2d,%2d    %s",key.length(),i+1,idx+1,"Right")); // + 1 porque os indices começam em 0

          // Escrever no soupOutput a palavra da esquerda para a direita
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[i][idx + j] = upperCaseKey.charAt(j);
          }
        } else if (horizontal.get(i).contains(reverseString(upperCaseKey)))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(reverseString(upperCaseKey), horizontal.get(i));
          entry.setValue(String.format("%2d    %2d,%2d    %s", key.length(), i + 1, idx + key.length(),"Left"));

          // Escrever no soupOutput a palavra da direita para a esquerda
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[i][j + idx] = upperCaseKey.charAt(key.length() - j - 1);
          }
        }
      }
    }
    
    // Procurar vertical
    for (i = 0; i < soupLength; i++)
    {
      for (Map.Entry<String,String> entry : KeyWords.entrySet())
      {
        String key = entry.getKey();
        String upperCaseKey = key.toUpperCase();
        String value = entry.getValue();

        if (vertical.get(i).contains(upperCaseKey))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(upperCaseKey, vertical.get(i));
          entry.setValue(String.format("%2d    %2d,%2d    %s", key.length(), idx + 1, i + 1,"Down")); // + 1 porque os indices começam em 0

          // Escrever no soupOutput a palavra da esquerda para a direita
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[idx + j][i] = upperCaseKey.charAt(j);
          }
        } else if (vertical.get(i).contains(reverseString(upperCaseKey)))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(reverseString(upperCaseKey), vertical.get(i));
          entry.setValue(String.format("%2d    %2d,%2d    %s", key.length(), idx + key.length(), i + 1, "Up"));
          
          // Escrever no soupOutput a palavra da direita para a esquerda
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[j + idx][i] = upperCaseKey.charAt(key.length() - j - 1);
          }
        }
      }
    }

    // Procurar diagonal - da esquerda para a direita
    for (String linhaDiagonal : diagonalLeftRight.keySet())
    {
      line = diagonalLeftRight.get(linhaDiagonal).get(0); 
      col = diagonalLeftRight.get(linhaDiagonal).get(1); 
      for (Map.Entry<String,String> entry : KeyWords.entrySet())
      {
        String key = entry.getKey();
        String upperCaseKey = key.toUpperCase();
        String value = entry.getValue();
        
        if (linhaDiagonal.contains(upperCaseKey))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(upperCaseKey, linhaDiagonal);
          entry.setValue(String.format("%2d    %2d,%2d    %s", key.length(), line + idx + 1, col + idx + 1,"DownRight")); // + 1 por causa do idx começar em 0!!

          // Escrever no soupOutput a palavra
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[line + idx + j][col + idx + j] = upperCaseKey.charAt(j);
          }
        } else if (linhaDiagonal.contains(reverseString(upperCaseKey)))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(reverseString(upperCaseKey), linhaDiagonal);
          entry.setValue(String.format("%2d    %2d,%2d    %s", key.length(), line + idx + key.length(), col + idx + key.length(),"UpLeft"));

          // Escrever no soupOutput a palavra
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[line + idx + j][col + idx + j] = upperCaseKey.charAt(key.length() - j - 1);
          }
        }

      }
    }

    // Procurar diagonal - da direita para a esquerda
    for (String linhaDiagonal : diagonalRightLeft.keySet())
    {
      line = diagonalRightLeft.get(linhaDiagonal).get(0); 
      col = diagonalRightLeft.get(linhaDiagonal).get(1); 
      for (Map.Entry<String,String> entry : KeyWords.entrySet())
      {
        String key = entry.getKey();
        String upperCaseKey = key.toUpperCase();
        String value = entry.getValue(); 
        
        if (linhaDiagonal.contains(upperCaseKey))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(upperCaseKey, linhaDiagonal);
          entry.setValue(String.format("%2d    %2d,%2d    %s", key.length(),line + idx + 1, col - idx + 1,"DownLeft")); // + 1 por causa dos indices começarem em 0

          // Escrever no soupOutput a palavra
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[line + idx + j][col - idx - j] = upperCaseKey.charAt(j); 
          }
        } else if (linhaDiagonal.contains(reverseString(upperCaseKey)))
        {
          if(!value.isEmpty())
            throw new IllegalArgumentException(String.format("Cada palavra só pode estar no puzzle uma vez; Palavra Repetida: %s",key));

          idx = getPosition(reverseString(upperCaseKey), linhaDiagonal);
          entry.setValue(String.format("%2d    %2d,%2d    %s", key.length(), line + idx + key.length(), (col + 1) - idx - (key.length() - 1) ,"UpRight")); 
          // Escrever no soupOutput a palavra
          
          for (j = 0; j < key.length(); j++)
          {
            soupOutput[line + idx + j][col - idx - j] = upperCaseKey.charAt(key.length() - j - 1);
          }
        }

      }
    }
    
    for (Map.Entry<String,String> entry: KeyWords.entrySet())
    {
      if(entry.getValue().isEmpty())
        throw new IllegalArgumentException(String.format("Todas as palavras da lista têm de estar no puzzle; Palavra Não encontrada: %s",entry.getKey()));
    }

    setSoupOutput(soupOutput);
  }




  // Devolve em que posição começa a string "keyword" dentro de "phrase" (assumido que elas se intersetam)
  private static int getPosition(String keyword, String phrase)
  {
    if (phrase.contains(keyword) == false) return -1;
    int count;

    for (int i = 0; i < phrase.length() - keyword.length() + 1; i++)
    {
      if (phrase.charAt(i) == keyword.charAt(0))
      {
        count = 1;
        while (count + 1 != keyword.length())
        {
          if (phrase.charAt(i + count) != keyword.charAt(count)) break;
          count++;
        }
        if (count + 1 == keyword.length()) return i;
      }
    }
    return -1;
  }

  private static String reverseString(String s)
  {
    return new StringBuilder(s).reverse().toString(); 
  }

  public String toString() {
    String s = "";
    int i, j;
    int wordMaxSize = horizontal.size();         // tamanho da sopa de letras é o maior tamanho possível de uma palavra

    for  (Map.Entry<String, String> entry : KeyWords.entrySet())
      s += String.format("%-"+wordMaxSize+"s    %s\n", entry.getKey(),entry.getValue());
    s += "\n";

    // NOTA: soupOutput é sempre uma matriz quadrada de chars
    for (i = 0; i < soupOutput.length; i++){
      for (j = 0; j < soupOutput.length; j++)
        s += soupOutput[i][j] + " ";
      s += "\n";
    }
    return s;
  }

  public void writeOutputFile(String fname) throws IOException {
    String[] split = fname.split("[.]");
    File outputFile = new File(split[0] + "_result.txt");
    PrintWriter out;
    if (outputFile.createNewFile())
    {
      out = new PrintWriter(outputFile);
      out.print(this.toString());;
    } else {
      System.out.println("File already exists.");
      return;
    }
    out.close();
  }
}

/*

REQUISITOS DE ENTRADA
1. O puzzle é sempre quadrado, com o tamanho máximo de 40x40.                     CHECK:)                       
2. As letras do puzzle estão em maiúscula.                                        CHECK:) 
3. Na lista, as palavras podem estar só em minúsculas, ou misturadas.             CHECK:)
4. As palavras são compostas por caracteres alfabéticos.                          CHECK:) 
5. No puzzle e na lista de palavras, o ficheiro não pode conter linhas vazias.    CHECK:)
6. Cada linha pode ter mais do que uma palavra, separadas por vírgula, espaço ou 
ponto e vírgula.                                                                  CHECK:) 
7. As palavras têm de ter pelo menos 3 caracteres.                                CHECK:) 
8. Todas as palavras da lista têm de estar no puzzle e apenas uma vez.            CHECK:)   
9. A lista de palavras pode conter palavras com partes iguais (por exemplo, pode
conter FARO e FAROL). Nestes casos deve ser considerado apenas a maior
(FAROL).                                                                          CHECK:)

*/
