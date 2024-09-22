import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SistemaReservasMediator mediator = new SistemaReservasMediator();
        GerenteRestaurante gerenteRestaurante = new GerenteRestaurante();
        Cliente cliente = new Cliente(mediator);

        mediator.setGerenteRestaurante(gerenteRestaurante);

        cliente.fazerReserva(3, LocalDateTime.now().plusHours(2));
        cliente.fazerReserva(5, LocalDateTime.now().plusHours(3));
        cliente.fazerReserva(8, LocalDateTime.now().plusHours(4));
    }
}