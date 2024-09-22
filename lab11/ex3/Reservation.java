public class Reservation implements State{
    @Override
    public void register(Book wrapper) {
        System.out.println("Cant do this");
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
        wrapper.setState(new Available());
    }    

    public String toString(){
        return "[Reservation]";
    }
}

