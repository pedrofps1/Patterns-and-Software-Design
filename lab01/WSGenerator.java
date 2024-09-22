import java.util.*;
import java.io.*;

public class WSGenerator {
    public static void main(String[] args) throws IOException{
        Ex2 info = new Ex2(args);
        ArrayList<String> palavras = info.getPalavras();
        int size = info.getSize();

        char[][] grid = new char[size][size]; //grid vazia para ser preenchida por letras
        colocar_palavras(grid, palavras);

        for(String i : palavras){
            System.out.println(i);
        }

        //se houver um argumento com o ficheiro de saida chama a funçao
        if(info.getFileOut() != null){
            printToFile(grid, palavras, info.getFileOut());
        }
    }

    //recebe um array bidimensional e um arraylist de palavras, a função vai preencher o array com as palavras em posições aleatórias
    // e de seguida preencher o mesmo com letras aleatórias de forma a completar a grid
    public static char[][] colocar_palavras(char[][] grid, ArrayList<String> palavras){
        Random rand = new Random(); // random para gerar posições e direções aleatórias
        for(String palavra : palavras){ 
            boolean colocada = false; 
            while(!colocada){ // necessário porque a primeira posição com uma certa direção gerada aleatoriamente pode nao ter espaço para a palavra, logo precisa de gerar outra vez
                int row = rand.nextInt(grid.length);
                int col = rand.nextInt(grid[0].length);
                int direction = rand.nextInt(8);
                boolean works = true;
                int size = palavra.length();
                palavra = palavra.toUpperCase();

                if(direction == 0){ //direita
                    if(col + size <= grid.length){
                        for (int i = 0; i < size; i++) { //inicialmente verifica se é possivel colocar a palavra nesta posição com a direção indicada
                            if (grid[row][col+i] != '\u0000') { //'\u0000' corresponde ao caracter vazio, entra no if caso a posição esteja ocupada 
                                if (grid[row][col+i] != palavra.charAt(i)) {  // verifica se a letra na posição é igual à letra da palavra que ia ficar na posição
                                    works = false;  //caso nao seja, entra aqui e coloca a variavel booleana a falso e para de comparar caracteres pois não é possivel colocar a
                                    break;
                                }
                            }
                        }
                        if(works==true){ //caso seja possivel colocar a palavra aqui, vai percorrer a linha e/ou coluna(dependendo da direção) e preenche os caracteres da grid correspondentes com a palavra
                            for(int i = 0; i < size; i++){
                                grid[row][col+i] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }
                //mesmo processo para todas as direções, mudando apenas as posições da grid dependendo da direção
                else if(direction == 1){ //esquerda
                    if(col - size >= 0){
                        for (int i = 0; i < size; i++) {
                            if (grid[row][col-i] != '\u0000') {
                                if (grid[row][col-i] != palavra.charAt(i)) { 
                                    works = false;
                                    break;
                                } 
                            }
                        }
                        if(works==true){
                            for(int i = 0; i < size; i++){
                                grid[row][col-i] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }

                else if(direction == 2){ //baixo
                    if(row + size <= grid.length){
                        for (int i = 0; i < size; i++) {
                            if (grid[row+i][col] != '\u0000') {
                                if (grid[row+i][col] != palavra.charAt(i)) { 
                                    works = false;
                                    break;
                                } 
                            }
                        }
                        if(works==true){
                            for(int i = 0; i < size; i++){
                                grid[row+i][col] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }

                else if(direction == 3){ //cima
                    if(row - size >= 0){
                        for (int i = 0; i < size; i++) {
                            if (grid[row-i][col] != '\u0000') {
                                if (grid[row-i][col] != palavra.charAt(i)) { 
                                    works = false;
                                    break;
                                } 
                            }
                            
                        }
                        if(works==true){
                            for(int i = 0; i < size; i++){
                                grid[row-i][col] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }

                if(direction == 4){ //downright
                    if(col + size <= grid.length && row + size <= grid.length){
                        for (int i = 0; i < size; i++) {
                            if(grid[row+i][col+i] != '\u0000'){
                                if(grid[row+i][col+i] != palavra.charAt(i)){
                                    works = false;
                                    break;
                                }
                            }
                        }
                        if(works==true){
                            for(int i = 0; i < size; i++){
                                grid[row+i][col+i] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }

                if(direction == 5){ //downleft
                    if(col - size >= 0 && row + size <= grid.length){
                        for (int i = 0; i < size; i++) {
                            if(grid[row+i][col-i] != '\u0000'){
                                if(grid[row+i][col-i] != palavra.charAt(i)){
                                    works = false;
                                    break;
                                }
                            }
                        }
                        if(works==true){
                            for(int i = 0; i < size; i++){
                                grid[row+i][col-i] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }

                if(direction == 6){ //upleft
                    if(col - size >= 0 && row - size >= 0){
                        for (int i = 0; i < size; i++) {
                            if(grid[row-i][col-i] != '\u0000'){
                                if(grid[row-i][col-i] != palavra.charAt(i)){
                                    works = false;
                                    break;
                                }
                            }
                        }
                        if(works==true){
                            for(int i = 0; i < size; i++){
                                grid[row-i][col-i] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }

                if(direction == 7){ //upright
                    if(col + size <= grid.length && row - size >= 0){
                        for (int i = 0; i < size; i++) {
                            if(grid[row-i][col+i] != '\u0000'){
                                if(grid[row-i][col+i] != palavra.charAt(i)){
                                    works = false;
                                    break;
                                }
                            }
                        }
                        if(works==true){
                            for(int i = 0; i < size; i++){
                                grid[row-i][col+i] = palavra.charAt(i);
                            }
                            colocada = true;
                        }
                    }
                }
            }
        }


        // for (char[] row : grid){
        //     for (int i = 0; i<row.length; i++){
        //         if(row[i] == '\u0000'){
        //             row[i] = '.';
        //         }
        //     }
        // }

        //percorre a grid, caso a posição esteja vazia preenche com uma letra aleatoria. É gerado um número aleatório entre 0 e 25 e é adicionado a 'A' para gerar letra
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j] == '\u0000'){
                    char randomLetter = (char) (rand.nextInt(26) + 'A');
                    grid[i][j] = randomLetter;
                }
            }
        }

        //print da grid
        for (int i = 0; i < grid.length; i++) {
            System.out.println(grid[i]);
        }

        return grid;
    }

    //print das palavras e da grid no ficheiro de saida, recebe grid, arraylist com as palavras que estão na grid e o nome do ficheiro
    public static void printToFile(char[][] grid, ArrayList<String> palavras, String file){
        try{
            File f = new File(file);

            PrintWriter pw = new PrintWriter(f);

            //print da grid
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    pw.print(grid[i][j]);
                }
                pw.println();
            }
            for(String palavra : palavras){ //print das palavras no arraylist
                pw.println(palavra.toString());
            }

            pw.close();
        }catch(IOException e){
            System.out.println("Erro");
        }
    }
}
