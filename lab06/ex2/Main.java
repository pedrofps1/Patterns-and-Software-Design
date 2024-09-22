import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main (String[] args) {

        try {
            File file = new File("Contacts.txt");
            file.createNewFile();

            FileWriter f = new FileWriter(file);
            f.write("Sara\t912345678\n");
            f.write("Pedro\t912221378\n");
            f.write("Maria\t945643212\n");

            f.close();

        } catch (IOException e) {
            System.err.println("ERROR");
            System.exit(0);
        }

        StorageTxt contacts = new StorageTxt("Contacts.txt");

        ContactsImplementation list = new ContactsImplementation();

        list.openAndLoad(contacts);

        Contact contato1 = new Contact("Luis" , 999999999);
        Contact contato2 = new Contact("Chico" , 923412355);

        list.add(contato1);
        list.add(contato2);

        list.remove(contato1);

        System.out.println(list.exist(contato1));
        System.out.println(list.exist(contato2));
        list.remove(list.getByName("Maria"));

        // Verify if the contact exists
        if(list.exist(list.getByName("Pedro"))) {
            System.out.println("Pedro esta na lista");
        }
        else {
            System.out.println("Pedro nao esta na lista");
        }

        list.saveAndClose();    
        
    }
}