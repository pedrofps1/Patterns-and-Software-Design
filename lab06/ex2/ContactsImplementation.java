
import java.util.ArrayList;
import java.util.List;

public class ContactsImplementation implements ContactsInterface{
    protected List<Contact> contactos;
    protected ContactsStorageInterface storage;

    public ContactsImplementation () {
        this.contactos = new ArrayList<>();
    }

    public void openAndLoad(ContactsStorageInterface store){
        this.storage = store;
        this.contactos.addAll(store.loadContacts());
        for(Contact contacto : contactos){
            System.out.println(contacto);
        }
    }

    public void saveAndClose(){
        boolean saved = storage.saveContacts(contactos);
        if(saved == false){
            System.out.println("Nao foi salvo");
        }
    }

    public void saveAndClose(ContactsStorageInterface store) {
        boolean saved = store.saveContacts(this.contactos);
        if(saved == false){
            System.out.println("Nao foi salvo");
        }
    }
    
    public boolean exist(Contact contact) {
        for(Contact contacto : contactos){
            if(contact.getName()==contacto.getName() && contact.getPhone() == contacto.getPhone()){
                return true;
            }
        }
        return false;
    }

    public Contact getByName(String name){
        for(Contact contacto : contactos){
            if(contacto.getName().equals(name)){
                return contacto;
            }
        }
        System.out.println("Nao encontrado");
        return null;
    }

    public Contact getByPhone (int phone) {
        for (Contact contacto : contactos) {
            if (contacto.getPhone() == phone) {
                return contacto;
            }
        }
        System.out.println("Nao encontrado");
        return null;
    }

    public boolean add(Contact contact){
        if(exist(contact)){
            return false;
        }
        contactos.add(contact);
        return true;
    }

    public boolean remove(Contact contact){
        if(!exist(contact)){
            return false;
        }
        contactos.remove(contact);
        return true;
    }
}
