
public interface State {
    void register(Book wrapper);
    void request(Book wrapper);
    void returns(Book wrapper);
    void reservation(Book wrapper);
    void cancel(Book wrapper);
}
