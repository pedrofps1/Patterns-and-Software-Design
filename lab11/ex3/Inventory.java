public class Inventory implements State{

    @Override
    public void register(Book wrapper) {
        wrapper.setState(new Available());
    }

    @Override
    public void request(Book wrapper) {
        System.out.println("Cant do this");
    }

    @Override
    public void returns(Book wrapper) {
        System.out.println("Cant do this");
    }

    @Override
    public void reservation(Book wrapper) {
        System.out.println("Cant do this");
    }

    @Override
    public void cancel(Book wrapper) {
        System.out.println("Cant do this");
    }

    public String toString(){
        return "[Inventory]";
    }
    
}
