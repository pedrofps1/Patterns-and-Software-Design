
import java.io.*;
import java.util.*;

public class Ex {
    private int tamanho;
    private char[][] sopa;
    private ArrayList<String> palavras;
    private ArrayList<String> colunas;
    private ArrayList<String> reverse_colunas;
    private ArrayList<String> linhas;
    private ArrayList<String> reverse_linhas;

    public Ex(String file) throws FileNotFoundException {
        if(file == null){
            System.err.println("Erro -- fomato: java WSSolver.java inputfile.txt outputfile.txt(opcional)");
            System.exit(1);
        }
        File sopa = new File(file);
        Scanner sc = new Scanner(sopa);
        String primeira_linha = sc.nextLine(); //primeira linha da sopa para ver tamanho
        if(primeira_linha == ""){
            System.err.println("Erro: linha vazia");
            System.exit(1);
        }
        this.tamanho = primeira_linha.length();// matriz é quadrada
        if (tamanho > 40 || tamanho < 3) {
            System.err.println("Erro: Tamanho inválido");
            sc.close();
            System.exit(1);
        }

        this.sopa = new char[tamanho][tamanho];
        //ver se letras da primeira linha da sopa sao maiusculas
        for (int i = 0; i < tamanho; i++) {
            if (Character.isUpperCase(primeira_linha.charAt(i)) && !Character.isDigit(primeira_linha.charAt(i))) {
                this.sopa[0][i] = primeira_linha.charAt(i);
            } else {
                System.err.println("Erro: letra da sopa de letras tem de ser maiuscula (non-numeric character)");
                System.exit(1);
            }
        }

        //ver se letras das restantes linhas da sopa sao maiusculas
        for (int i = 1; i < tamanho; i++) {
            String linha = sc.nextLine();
            if(linha == ""){
                System.err.println("Erro: linha vazia");
                System.exit(1);
            }
            if(linha.length() != tamanho) {
                System.err.println("Erro: tamanho de linha invalido (matriz nao quadrada)");
                System.exit(1);
            }
            for (int j = 0; j < tamanho; j++) {
                if (Character.isUpperCase(linha.charAt(j)) && !Character.isDigit(linha.charAt(j))) {
                    this.sopa[i][j] = linha.charAt(j);
                } else {
                    System.err.println("Erro: letra da sopa de letras tem de ser maiuscula (non-numeric character)" );
                    System.exit(1);
                }
            }
        }

        palavras = new ArrayList<String>();
        while (sc.hasNextLine()) { //percorrer restantes linhas, tirar palavras para arraylist e verificar se letras sao minusculas e palavras tem 3 ou mais caracteres
            String linha = sc.nextLine();
            if(linha == ""){
                System.err.println("Erro: linha vazia");
                System.exit(1);
            }
            String[] array_palavras = linha.split("[\\s;,]");
            for (int i = 0; i < array_palavras.length; i++) {
                boolean valid = false;
                if (array_palavras[i].length() >= 3) {
                    for (int j = 0; j < array_palavras[i].length(); j++) {
                        if (Character.isLowerCase(array_palavras[i].charAt(j))){
                            valid = true;
                        }
                        if(Character.isDigit(array_palavras[i].charAt(j))){
                            System.err.println("Erro: palavra nao pode conter numeros");
                            System.exit(1);
                        }
                    }
                } else {
                    System.err.println("Erro: palavras tem de ter pelo menos 3 caracteres");
                    System.exit(1);
                }
                if(valid==false){
                    System.err.println("Erro: palavra nao pode conter apenas caracteres maisculos");
                    System.exit(1);
                }
                this.palavras.add(array_palavras[i]);
            }
        }

        linhas = getRows(this.sopa);
        reverse_linhas = reverseArrayList(linhas);
        colunas = getColumns(this.sopa);
        reverse_colunas = reverseArrayList(colunas);
    }

    //função para devolver arraylist de colunas
    public static ArrayList<String> getColumns(char[][] grid) {
        ArrayList<String> columns = new ArrayList<String>();
        int numRows = grid.length;
        int numCols = grid[0].length;
        for (int col = 0; col < numCols; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < numRows; row++) {
                sb.append(grid[row][col]);
            }
            columns.add(sb.toString());
        }
        return columns;
    }

    //função para devolver arraylist de linhas
    public static ArrayList<String> getRows(char[][] grid) {
        ArrayList<String> rows = new ArrayList<String>();
        for (int row = 0; row < grid.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < grid[row].length; col++) {
                sb.append(grid[row][col]);
            }
            rows.add(sb.toString());
        }
        return rows;
    }

    //função que recebe um arraylist de strings e devolve lista de strings invertidos
    public static ArrayList<String> reverseArrayList(ArrayList<String> list) {
        ArrayList<String> reversedList = new ArrayList<String>();
        for (String str : list) {
            String reversedStr = new StringBuilder(str).reverse().toString();
            reversedList.add(reversedStr);
        }
        return reversedList;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public char[][] getSopa() {
        return this.sopa;
    }

    public ArrayList<String> getPalavras() {
        return this.palavras;
    }

    public ArrayList<String> getColunas() {
        return this.colunas;
    }

    public ArrayList<String> getReverse_colunas() {
        return this.reverse_colunas;
    }

    public ArrayList<String> getLinhas() {
        return this.linhas;
    }

    public ArrayList<String> getReverse_linhas() {
        return this.reverse_linhas;
    }
}