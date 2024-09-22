
import java.util.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class StorageBinary implements ContactsStorageInterface{
    private String file;

    public StorageBinary(String file){
        this.file = file;
    }

    public List<Contact> loadContacts(){
        List<Contact> contacts = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            while(dis.available() > 0){
                String name = dis.readUTF();
                int phone = dis.readInt();
                contacts.add(new Contact(name, phone));
            }
            fis.close();
        } catch (Exception e) {
            System.out.println("Error");
            System.exit(1);
        }
        return contacts; 
    }
    

    public boolean saveContacts(List<Contact> list){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            for(Contact contacto : list){
                String c = contacto.getName() + " " + contacto.getPhone() + "\n";
                dos.write(c.getBytes());
            }
            fos.close();
            return true;
        } catch (Exception e) {
            System.out.println("Ficheiro nao encontrado");
            return false;
        }
    }
    
}
