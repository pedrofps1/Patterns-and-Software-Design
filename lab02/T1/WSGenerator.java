import java.io.IOException;
import java.util.ArrayList;

public class WSGenerator {
    public static void main(String[] args) throws IOException{
        String inputFile = "", outputFile = "";
        String[] aux;
        int size = 0;
        ArrayList<String> inputWords;
        if (args.length == 4)   // 2 opções: -i (nome do input) -s (tamanho da sopa)
        {
            if (args[0].charAt(0) != '-') // tem de começar com uma opção
            {
                System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                System.exit(1);
            }
            for (int i = 0; i < args.length - 1; i++)
            {
                if (args[i].equals("-i")) {
                    if (args[i + 1].charAt(0) == '-') {
                        System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                        System.exit(1);

                    } 
                    aux = args[i + 1].split("[.]");
                    if (aux.length != 2 || !aux[1].equals("txt")) // se nao tiver extensão ou esta for diferente de .txt
                    {
                        System.err.println("Invalid input file.");
                        System.exit(1);

                    }
                    inputFile = args[i + 1];
                    i++;    // avançar para a proxima opção caso exista
                }
                else if (args[i].equals("-s")) {
                    if (args[i + 1].charAt(0) == '-') {
                        System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                        System.exit(1);

                    }
                    if (!args[i + 1].matches("[0-9]+")) 
                    {
                        System.err.println("Invalid size.");
                        System.exit(1);

                    }
                    size = Integer.parseInt(args[i + 1]);
                    if (size < 3 && size > 40) 
                    {
                        System.err.println("Invalid size, must be greater than 3 and lower than 40");
                        System.exit(1);

                    }
                    i++;    // avançar para a proxima opção caso exista

                } else {
                    System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                    System.exit(1);

                }
            }
            inputWords = SoupGenerator.readData(inputFile);
            // Validação das palavras
            if (!SoupGenerator.validate(inputWords, size)) {
                System.err.println("Invalid input content.");
                System.exit(1);

            }
            inputWords = SoupGenerator.readData(inputFile);
            // Validação das palavras
            if (!SoupGenerator.validate(inputWords, size)) return;
            SoupGenerator generator = new SoupGenerator(inputWords, size);
            generator.generateSoup();
            generator.produceOutput();

        } else if (args.length == 6) // 3 opções: -i (nome) -s (size) -o (output nome)
        {
            if (args[0].charAt(0) != '-') // tem de começar com uma opção
            {
                System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                System.exit(1);

            }
            for (int i = 0; i < args.length - 1; i++)
            {
                if (args[i].equals("-i")) {
                    if (args[i + 1].charAt(0) == '-') {
                        System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                        System.exit(1);

                    }
                    aux = args[i + 1].split("[.]");
                    if (aux.length != 2 || !aux[1].equals("txt")) // se nao tiver extensão ou esta for diferente de .txt
                    {
                        System.err.println("Invalid input file.");
                        System.exit(1);

                    }
                    inputFile = args[i + 1];
                    i++;    // avançar para a proxima opção caso exista
                }
                else if (args[i].equals("-s")) {
                    if (args[i + 1].charAt(0) == '-') {
                        System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                        System.exit(1);

                    }
                    if (!args[i + 1].matches("[0-9]+")) 
                    {
                        System.err.println("Invalid size.");
                        System.exit(1);

                    }
                    size = Integer.parseInt(args[i + 1]);
                    if (size < 3 && size > 40) 
                    {
                        System.err.println("Invalid size, must be greater than 3 and lower than 40");
                        System.exit(1);

                    }
                    i++;    // avançar para a proxima opção caso exista
                } else if (args[i].equals("-o")) {
                    if (args[i + 1].charAt(0) == '-') {
                        System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                        System.exit(1);

                    }
                    aux = args[i + 1].split("[.]");
                    if (aux.length != 2 || !aux[1].equals("txt")) // se nao tiver extensão ou esta for diferente de .txt
                    {
                        System.err.println("Invalid output file.");
                        System.exit(1);

                    }
                    outputFile = args[i + 1];
                    i++;    // avançar para a proxima opção caso exista
                } else {
                    System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
                    System.exit(1);

                }
            }
            inputWords = SoupGenerator.readData(inputFile);
            // Validação das palavras
            if (!SoupGenerator.validate(inputWords, size)) return;
            SoupGenerator generator = new SoupGenerator(inputWords, size, outputFile);
            generator.generateSoup();
            generator.produceOutput();
        } else {
            System.err.println("USAGE: \t WSGenerator -i <inputFile> -s <word search size> [-o outputName]");
            System.exit(1);
        }
        
    }
}
