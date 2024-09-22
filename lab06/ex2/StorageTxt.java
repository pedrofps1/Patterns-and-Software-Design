
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageTxt implements ContactsStorageInterface{
    private String file;

    public StorageTxt(String file){
        this.file = file;
    }

    public List<Contact> loadContacts(){
        List<Contact> contacts = new ArrayList<>();
        try {
            File f = new File(file);
            Scanner sc = new Scanner(f);
            String linha;
            while(sc.hasNextLine()){
                linha = sc.nextLine();
                String[] c = linha.split("\t");
                contacts.add(new Contact(c[0], Integer.parseInt(c[1])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao encontrado");
            System.exit(1);
        }
        return contacts; 
    }

    public boolean saveContacts(List<Contact> list){
        try {
            FileWriter f = new FileWriter(file);
            for(Contact contacto : list){
                String c = contacto.getName() + " " + contacto.getPhone() + "\n";
                f.write(c);
            }
            f.close();
            return true;
        } catch (IOException e) {
            System.out.println("Ficheiro nao encontrado");
            return false;
        }
    }
}