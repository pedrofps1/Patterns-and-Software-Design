import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextReader implements ReaderInterface{
    private File txt;
    private Scanner sc;

    public TextReader(File txt) {
        this.txt = txt;

        try {
            this.sc = new Scanner(this.txt);
        } catch (FileNotFoundException e) {
            System.out.print("Error - file not found\n");   
            System.exit(0);         
        }
    }

    public boolean hasNext() {
        return sc.hasNext();
    }

    public String next(){
        return sc.nextLine();
    }
}