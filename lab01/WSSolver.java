import java.util.*;
import java.io.*;

public class WSSolver{
    public static void main(String[] args) throws FileNotFoundException{
        if(args.length == 0){
            System.err.println("Erro -- fomato: java WSSolver.java inputfile.txt");
            System.exit(1);
        }
        Ex sopa = new Ex(args[0]);

        ArrayList<String> colunas = sopa.getColunas();
        ArrayList<String> reverse_colunas = sopa.getReverse_colunas();
        ArrayList<String> linhas = sopa.getLinhas();
        ArrayList<String> reverse_linhas = sopa.getReverse_linhas();

        ArrayList<String> words_to_search = sopa.getPalavras();
        ArrayList<Word> words_searched = new ArrayList<>();

        int size = sopa.getTamanho();

        //percorrer todas as palavras a procurar
        for(String palavra : words_to_search){
            palavra = palavra.toUpperCase(); //colocar palavra em maiusculas para comparar com as letras da sopa(estão em maisculas)
            for(String linha : linhas){ //ver todas as linhas da sopa
                if(linha.contains(palavra)){ //se uma linha tem a palavra
                    int row = linhas.indexOf(linha) + 1; //obter linha+1 para imprimir mais tarde no terminal e no ficheiro
                    int col = linha.indexOf(palavra) + 1; //obter coluna+1 para imprimir mais tarde no terminal e no ficheiro
                    Word found = new Word(palavra.toLowerCase(), palavra.length(), row, col, "Right"); //criar nova Word(classe com argumentos que são precisos(palavra,tamanho,posiçoes e direçao))
                    words_searched.add(found); //adicionar a arraylist de palavras encontradas
                    break;
                }
            }
            //mesmo processo para todas as direções mudando rows e colunas de acordo com a direção 
            for(String linha : reverse_linhas){
                if(linha.contains(palavra)){
                    int row = reverse_linhas.indexOf(linha)+1;
                    int col = size - linha.indexOf(palavra);
                    Word found = new Word(palavra.toLowerCase(), palavra.length(), row, col, "Left");
                    words_searched.add(found);
                    break;
                }
            }

            for(String coluna : colunas){
                if(coluna.contains(palavra)){
                    int row = coluna.indexOf(palavra) + 1;
                    int col = colunas.indexOf(coluna) + 1;
                    Word found = new Word(palavra.toLowerCase(), palavra.length(), row, col, "Down");
                    words_searched.add(found);
                    break;
                }
            }

            for(String coluna : reverse_colunas){
                if(coluna.contains(palavra)){
                    int row = size - coluna.indexOf(palavra);
                    int col = reverse_colunas.indexOf(coluna) + 1;
                    Word found = new Word(palavra.toLowerCase(), palavra.length(), row, col, "Up");
                    words_searched.add(found);
                    break;
                }
            }

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    // downright
                    checkDiagonal(sopa, linhas, colunas, words_searched, palavra, row, col, 1, 1, "Downright");
            
                    // upright
                    checkDiagonal(sopa, linhas, colunas, words_searched, palavra, row, col, -1, 1, "Upright");
            
                    // downleft
                    checkDiagonal(sopa, linhas, colunas, words_searched, palavra, row, col, 1, -1, "Downleft");
            
                    // upleft
                    checkDiagonal(sopa, linhas, colunas, words_searched, palavra, row, col, -1, -1, "Upleft");
                }
            }

            
        }

        for (Word word : words_searched) {
            System.out.println(word);
        }

        System.out.println();

        char[][] grid_final = printGrid(words_searched, size);
        printToFile(grid_final, words_searched, args[0]);
    }

    //com o dr e o dc, mudar direção na grid de forma a obter linhas na direçao correta e tentar encontrar palavra. Caso encontre, criar nova Word com a informação correspondente
    public static void checkDiagonal(Ex sopa, ArrayList<String> linhas, ArrayList<String> colunas, ArrayList<Word> words_searched, String word, int row, int col, int dr, int dc, String direction) {
        int ri = row + 1;
        int ci = col + 1;
        StringBuilder sb = new StringBuilder();
        int size = sopa.getTamanho();
        while (row >= 0 && row < size && col >= 0 && col < size) {
            sb.append(linhas.get(row).charAt(col));
            sb = toLowerCase(sb);
            if (sb.toString().equals(word.toLowerCase())) {
                Word w = new Word(word.toLowerCase(), word.length(), ri, ci, direction);
                words_searched.add(w);
            }
            row += dr;
            col += dc;
        }
    }


    public static StringBuilder toLowerCase(StringBuilder linha) {
        for (int i = 0; i < linha.length(); i++) {
            if (Character.isUpperCase(linha.charAt(i))) {
                linha.setCharAt(i, Character.toLowerCase(linha.charAt(i)));
            }
        }
        return linha;
    }

    //função que imprime grid
    public static char[][] printGrid(ArrayList<Word> palavras, int tamanho){
        char[][] grid = new char[tamanho][tamanho];

        //preencher grid com pontos
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                grid[i][j] = '.';
            }
        }

        //para cada palavra, obter coluna, linha e direção e imprimir cada caracter. A cada impressão, aumenta/diminui a coluna e/ou linha, dependendo da direção
        for(Word palavra : palavras){
            int row = palavra.getRow()-1;
            int col = palavra.getCol()-1;
            for (int i = 0; i < palavra.getLength(); i++) {
                grid[row][col] = Character.toUpperCase(palavra.getText().charAt(i));
                if (palavra.getDirection().equals("Up")) {
                    row--;
                } else if (palavra.getDirection().equals("Down")) {
                    row++;
                } else if (palavra.getDirection().equals("Left")) {
                    col--;
                } else if (palavra.getDirection().equals("Right")) {
                    col++;
                } else if (palavra.getDirection().equals("Upleft")) {
                    row--;
                    col--;
                } else if (palavra.getDirection().equals("Upright")) {
                    row--;
                    col++;
                } else if (palavra.getDirection().equals("Downleft")) {
                    row++;
                    col--;
                } else if (palavra.getDirection().equals("Downright")) {
                    row++;
                    col++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        return grid;
    }

    //print para o ficheiro file
    public static void printToFile(char[][] grid, ArrayList<Word> palavras, String file){
        try{
            String[] s = file.split("\\.");
            file = s[0] + "_result.txt";
            File f = new File(file);

            PrintWriter pw = new PrintWriter(f);
            for(Word palavra : palavras){
                pw.println(palavra.toString());
            }

            pw.println();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    pw.print(grid[i][j]);
                }
                pw.println();
            }

            pw.close();
        }catch(IOException e){
            System.out.println("Erro");
        }
    }
}