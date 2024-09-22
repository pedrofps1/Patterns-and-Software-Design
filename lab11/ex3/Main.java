import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        Book book1 = new Book("Java Anti-Stress", "1-1", 2020, "Omodionah");
        Book book2 = new Book("A Guerra dos Padrões", "2-2", 2020, "Jorge Omel");
        Book book3 = new Book("A Procura da Luz", "3-3", 2021, "Khumatkli");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        System.out.println(books.size());
        String in ="";

        Scanner sc = new Scanner(System.in);
        do{
            try{
                System.out.println("** Biblioteca **");
                for(int i = 0; i < books.size(); i++){
                    System.out.print(i+1 + " " + books.get(i).toString());
                }
                System.out.println(">> <livro>, <operacao: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");

                in = sc.nextLine();
                String[] in_split = in.split(",");
                int id = Integer.parseInt(in_split[0]);
                int op = Integer.parseInt(in_split[1]);

                Book b = books.get(id-1);
                
                if(op == 1){
                    b.register();
                }
                else if(op == 2){
                    b.request();
                }
                else if(op == 3){
                    b.returns();
                }
                else if(op == 4){
                    b.reservation();
                }
                else if(op == 5){
                    b.cancel();
                }
                else{
                    throw new IllegalArgumentException("Invalid input");
                }
                System.out.println();
            }
            catch(NumberFormatException e) {
                System.out.println("Error, invalid number format!");
            }
        }while(in != "");

        sc.close();
    }
}
