public class Book {
    private String titulo;
    private String isbn;
    private int ano;
    private String author;
    private State state;


    public Book(String titulo, String isbn, int ano, String author) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
        this.author = author;
        this.state = new Inventory();
    }
    

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void register(){
        state.register(this);
    }

    public void request(){
        state.request(this);
    }

    public void returns(){
        state.returns(this);
    }

    public void cancel(){
        state.returns(this);
    }

    public void reservation(){
        state.reservation(this);
    }

    public String toString(){
        return String.format("%-40s %-30s %-15s \n", this.getTitulo(), this.getAuthor(), this.getState());
    }
}
