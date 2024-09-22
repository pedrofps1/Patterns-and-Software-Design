import java.io.*;
import java.util.*;

public class Ex2 {
    String fileIn;
    int size= -1;
    String fileOut;
    ArrayList<String> palavras = new ArrayList<String>();


    public Ex2(String[] args) throws IOException{
        //percorrer args e tirar argumentos -- fileIn, size, fileOut
        if(args.length < 4){
            System.err.println("Erro: precisa de ter tamanho -- formato: java WSGenerator.java -i inputfile.txt -s tamanho -o(opcional) outfile.txt(opcional)");
            System.exit(1);
        }


        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-i")){
                fileIn = args[i+1];
            }
            else if(args[i].equals("-s")){
                size = Integer.parseInt(args[i+1]);
            }
            else if(args[i].equals("-o")){
                fileOut = args[i+1];
            }
        }

        if(size == -1){
            System.err.println("Erro: precisa de ter tamanho -- formato: java WSGenerator.java -i inputfile.txt -s tamanho -o(opcional) outfile.txt(opcional)");
            System.exit(1);
        }

        try{
            File f = new File(fileIn);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){ //percorrer cada linha do ficheiro de entrada, obter cada palavra que está lá e colocar no arraylist de palavras
                String linha = sc.nextLine();
                if(linha == ""){
                    System.err.println("Erro: Linha vazia");
                    System.exit(1);
                }
                String[] words = linha.split("[\\s;,]");
                for (int i = 0; i < words.length; i++) {
                    if(words[i].length() > size){
                        System.err.println("Erro: palavra muito grande para tamanho selecionado");
                        System.exit(1);
                    }
                    for (int j = 0; j < words[i].length(); j++) {
                        if(Character.isDigit(words[i].charAt(j))){
                            System.err.println("Erro: nao aceita numeros");
                            System.exit(1);
                        }
                    }
                    palavras.add(words[i]);
                }
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Erro");
        }
    }

    public String getFileIn() {
        return this.fileIn;
    }

    public int getSize() {
        return this.size;
    }
    
    public String getFileOut() {
        return this.fileOut;
    }

    public ArrayList<String> getPalavras() {
        return this.palavras;
    }
    
}   
