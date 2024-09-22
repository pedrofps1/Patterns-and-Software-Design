
public class Contact {
    private String name;
    private int phone;

    public Contact(String name, int phone){
        this.name=name;
        this.phone=phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String toString(){
        return "Nome: " + name + "; Numero: " + phone;
    }
}
