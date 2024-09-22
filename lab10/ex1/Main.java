public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Bolo", 2.0);
        Product product2 = new Product("Taco", 50.0);
        Product product3 = new Product("Telemovel", 200.0);

        Client client1 = new Client("Pedro");
        Client client2 = new Client("Sara");

        Manager manager = new Manager("Ruben");
        manager.regist(product1);
        manager.regist(product2);
        manager.regist(product3);

        product1.setState(StateProduct.AUCTION);
        product2.setState(StateProduct.AUCTION);

        client1.bid(product1, 3);
        System.out.println();
        client2.bid(product2, 60);
        System.out.println();

        product1.setState(StateProduct.AUCTION);

        client1.bid(product1, 100);
        System.out.println();

        client2.bid(product1, 200);
        System.out.println();

        product1.setState(StateProduct.SALES);
    }
}
