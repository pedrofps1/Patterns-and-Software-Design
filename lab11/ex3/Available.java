public class Available implements State{
    @Override
    public void register(Book wrapper) {
        System.out.println("Cant do this");
    }

    @Override
    public void request(Book wrapper) {
        wrapper.setState(new Borrowed());
    }

    @Override
    public void returns(Book wrapper) {
        System.out.println("Cant do this");
    }

    @Override
    public void reservation(Book wrapper) {
        wrapper.setState(new Reservation());
    }

    @Override
    public void cancel(Book wrapper) {
        System.out.println("Cant do this");
    }

    public String toString(){
        return "[Available]";
    }

}
