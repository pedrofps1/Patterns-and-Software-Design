import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import java.util.List;
import java.io.PrintWriter;


public class SoupGenerator {
    ArrayList<String> inputWords;
    int size;
    String outputFile;  // se for igual a "", então não foi dado como argumento de entrada
    char[][] soupMatrix;
    List<ArrayList<Integer>> occupiedPositions;


    SoupGenerator(ArrayList<String> inputWords, int size) {
        this.inputWords = inputWords;
        this.size = size;
        this.outputFile = "";
        this.soupMatrix = new char[size][size];
        this.occupiedPositions = new ArrayList<ArrayList<Integer>>();

        // inicialização
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                soupMatrix[i][j] = '.';
            }
        }
    }

    SoupGenerator(ArrayList<String>inputWords, int size, String outputFile) {
        this.inputWords = inputWords;
        this.size = size;
        this.outputFile = outputFile;
        this.soupMatrix = new char[size][size];
        this.occupiedPositions = new ArrayList<ArrayList<Integer>>();

        // inicialização
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                soupMatrix[i][j] = '.';
            }
        }
    }
    public ArrayList<String> getInputWords() {
        return inputWords;
    }
    public String getOutputFile() {
        return outputFile;
    }
    public int getSize() {
        return size;
    }
    public char[][] getSoupMatrix() {
        return soupMatrix;
    }
    public List<ArrayList<Integer>> getOccupiedPositions() {
        return occupiedPositions;
    }
    public void clearSoupMatrix() 
    {
        char[][] soupMatrix = this.getSoupMatrix();
        for (int i = 0; i < this.getSize(); i++)
        {
            for (int j = 0; j < this.getSize(); j++)
            {
                soupMatrix[i][j] = '.';
            }
        }
    }
    public void clearOccupiedPositions() {
        getOccupiedPositions().clear();
    }

    public void setSoupMatrix(char[][] soupMatrix) {
        this.soupMatrix = soupMatrix;
    }
    public void setOccupiedPositions(List<ArrayList<Integer>> occupiedPositions) {
        this.occupiedPositions = occupiedPositions;
    }
    

    public static ArrayList<String> readData(String inputFile) throws IOException {
        ArrayList<String> inputWords = new ArrayList<String>();

        boolean addWord = true;     // só adicionar se cumprir requisito de substring 
        File f = new File(inputFile);
        String currWord, compareWord;

        Scanner sc = new Scanner(f);
        sc.useDelimiter("\n| |,|;");        // palavras podem estar separadas por um destes delimiters
        
        
        while (sc.hasNext())
        {   
            currWord = sc.next();
            if (currWord.isBlank()) { // se ler uma linha for vazia no meio do ficheiro
                System.err.println("Cannot have empty lines.");
                System.exit(1);
            } 
            for (int i = 0; i < inputWords.size(); i++) // verificar se já existe uma palavra que é uma substring desta ou vice-versa
            {
                compareWord = inputWords.get(i);
                if (compareWord.contains(currWord) || currWord.contains(compareWord))
                {
                    if (currWord.compareTo(compareWord) > 0) // se for maior, remover a palavra menor
                    {
                        inputWords.remove(compareWord);
                        break;
                    } else if (currWord.compareTo(compareWord) <= 0) { // se for menor ou igual, nao adicionar
                        addWord = false;
                        break;
                    }
                }
            }
            if (addWord) inputWords.add(currWord);
            addWord = true;
        }
        sc.close();
        return inputWords;
    }


    public static boolean validate(ArrayList<String> inputWords, int size) {
        boolean retVal = true;
        String currWord;
        for (int i = 0; i < inputWords.size(); i++)
        {
            currWord = inputWords.get(i);
            // Palavra tem de ter pelo menos 3 letras (e caber na sopa)
            if ((currWord.length() < 3 || currWord.length() > size)) 
            {
                System.out.println("Invalid size of input words.");
                retVal = false;
                break;
            } else if (!currWord.toLowerCase().equals(currWord)) {
                System.out.println("Invalid input words: all words should be lower case.");
                retVal = false;
                break;
            }
        }
        return retVal;
    }

    // Aleatoriamente, meter as palavras na sopa de letras
    public void putInputWordsInSoup()
    {
        ArrayList<String> inputWords = this.getInputWords();
        List<ArrayList<Integer>> occupiedPositions = this.getOccupiedPositions();
        ArrayList<Integer> currPosition;

        char[][] soupMatrix = this.getSoupMatrix();
        int line, col, size = this.getSize();

        String[] orient = {"up", "down", "left", "right", "upleft", "upright", "downleft", "downright"};
        String currOrient, currWord;
        int wordLength;
        boolean validPosition, validHelp;

        // meter as palavras dadas na sopa
        Random rng = new Random();      // é capaz de valer a pena meter uma seed 

        for (int i = 0; i < inputWords.size(); i++) 
        {
            wordLength = inputWords.get(i).length();
            currWord = inputWords.get(i).toUpperCase();
            // experimentar orientação até dar (muito ineficiente porque pode experimentar a mesma orientação multiplas vezes)
            do {
                do {
                    line = rng.nextInt(size);
                    col = rng.nextInt(size);
                } while (soupMatrix[line][col] != '.' ); 
                validPosition = false;
                validHelp = true;
    
                currOrient = orient[rng.nextInt(orient.length)];    // orientação aleatoria

                switch (currOrient) {
                    // Verificar se para a orientação atual, é possível pôr lá a palavra
                    case ("up"):
                        if ((line - wordLength) < 0) break; // posição inválida porque ia atingir linha com indice negativo
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line - j][col] != '.') // se tiver valor
                            {
                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line - j][col] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                    case ("down"):
                        if ((line + wordLength) > this.getSize()) break; // posição inválida porque ia atingir linha com indice acima do max
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line + j][col] != '.') // se tiver valor
                            {
                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line + j][col] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                    case ("left"):
                        if ((col - wordLength) < 0) break; // posição inválida porque ia sair da matriz
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line][col - j] != '.') // se tiver valor
                            {
                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line][col - j] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                    case ("right"):
                        if ((col + wordLength) > this.getSize()) break; // posição inválida porque ia atingir linha com indice acima do max
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line][col + j] != '.') // se tiver valor
                            {

                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line][col + j] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                    case ("upleft"):
                        if ((col - wordLength) < 0 || (line - wordLength) < 0) break;
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line - j][col - j] != '.') // se tiver valor
                            {
                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line - j][col - j] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                    case ("upright"):
                        if ((col + wordLength) > this.getSize() || (line - wordLength) < 0) break; 
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line - j][col + j] != '.') // se tiver valor
                            {
                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line - j][col + j] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                    case("downleft"):
                        if ((col - wordLength) < 0 || (line + wordLength) > this.getSize()) break;
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line + j][col - j] != '.') // se tiver valor
                            {
                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line + j][col - j] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                    case ("downright"):
                        if ((col + wordLength) > this.getSize() || (line + wordLength) > this.getSize()) break; 
                        for (int j = 0; j < wordLength; j++)
                        {
                            if (soupMatrix[line + j][col + j] != '.') // se tiver valor
                            {
                                // se o valor na posição j não intersetar com a palavra atual na posição j, esta posição sera invalida
                                if (soupMatrix[line + j][col + j] != currWord.charAt(j)) {
                                    validHelp = false;
                                    break;
                                }
                            }
                        }
                        if (validHelp) validPosition = true;
                        break;
                }
            } while (validPosition == false);
            switch (currOrient)
            {
                case("up"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line - j][col] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line - j); currPosition.add(col);
                        occupiedPositions.add(currPosition);
                    }
                    break;
                case("down"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line + j][col] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line + j); currPosition.add(col);
                        occupiedPositions.add(currPosition);
                    }
                    break;
                case("left"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line][col - j] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line); currPosition.add(col - j);
                        occupiedPositions.add(currPosition);
                    }
                    break;
                case("right"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line][col + j] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line); currPosition.add(col + j);
                        occupiedPositions.add(currPosition);
                    }
                    break;
                case("upleft"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line - j][col - j] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line - j); currPosition.add(col - j);
                        occupiedPositions.add(currPosition);
                    }
                    break;
                case("upright"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line - j][col + j] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line - j); currPosition.add(col + j);
                        occupiedPositions.add(currPosition);
                    }
                    break;
                case("downleft"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line + j][col - j] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line + j); currPosition.add(col - j);
                        occupiedPositions.add(currPosition);
                    }
                    break;
                case("downright"):
                    for (int j = 0; j < wordLength; j++) {
                        soupMatrix[line + j][col + j] = currWord.charAt(j);
                        currPosition = new ArrayList<>();
                        currPosition.add(line + j); currPosition.add(col + j);
                        occupiedPositions.add(currPosition);
                    }
                    break;
            }
        }
        setSoupMatrix(soupMatrix);
        setOccupiedPositions(occupiedPositions);
    }

    public void generateSoup() {
        // preencher os espaços restantes com letras aleatorias (com o cuidado de não aparecer multiplas vezes as palavras de input)
        boolean done = false; // usada para saber quando é que a sopa está a cumprir o critério de não haverem multiplas ocorrencias de palavras de input
        char c;
        int exceptionCount = 0;     // se houverem multiplas exceptions seguidas, recomeçar o processo
        ArrayList<Integer> currPosition = new ArrayList<>();
        List<ArrayList<Integer>> occupiedPositions = this.getOccupiedPositions();

        SoupSolver testCurrentSoup;
        Random rng = new Random();

        this.putInputWordsInSoup(); // meter as palavras em posições aleatorias
        while (done == false) {
            try {   // solver devolve illegalargumentexception se o input não cumprir critérios
                if (exceptionCount == 5) {
                    clearSoupMatrix();
                    clearOccupiedPositions();
                    this.putInputWordsInSoup();
                    exceptionCount = 0;
                }
                for (int i = 0; i < this.getSize(); i++)
                {
                    for (int j = 0; j < this.getSize(); j++)
                    {
                        currPosition.add(i);
                        currPosition.add(j);
                        if (!occupiedPositions.contains(currPosition)) { // esta posição não estiver ocupada, meter letra aleatoria maiscula
                            c = (char)('A' + rng.nextInt(26));
                            soupMatrix[i][j] = c;
                        }
                        currPosition.clear();
                    }
                }
                testCurrentSoup = new SoupSolver(this.toString());
                testCurrentSoup.solve();
                done = true;
            } catch (IllegalArgumentException e) {
                exceptionCount++;
            }
        }
        setSoupMatrix(soupMatrix);
    }
    @Override
    public String toString() {
        String s = "";
        char[][] soupMatrix = this.getSoupMatrix();
        ArrayList<String> inputWords = this.getInputWords();
        for (int i = 0; i < this.getSize(); i++)
        {
            for (int j = 0; j < this.getSize(); j++)
            {
                s += soupMatrix[i][j];
            }
            s += "\n";
        }
        for (int i = 0; i < inputWords.size() - 1; i++)
        {
            s += inputWords.get(i) + "\n";
        }
        s += inputWords.get(inputWords.size() - 1);
        return s;
    }
    public void produceOutput() throws IOException {
        File f;
        PrintWriter out;
        if (outputFile == "")
        {
            System.out.println(toString()); 
        } else {
            f = new File(outputFile);
            out = new PrintWriter(f);
            out.print(this.toString()); 
            out.close(); 
        }
    }
}
