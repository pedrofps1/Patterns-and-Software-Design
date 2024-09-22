import java.time.LocalDateTime;

public class Cliente {
    private Mediator mediator;

    public Cliente(Mediator mediator) {
        this.mediator = mediator;
    }

    public void fazerReserva(int numeroMesa, LocalDateTime horario) {
        mediator.fazerReserva(this, numeroMesa, horario);
    }

    public void receberConfirmacaoReserva(int numeroMesa, LocalDateTime horario) {
        System.out.println("Reserva confirmada para a mesa " + numeroMesa + " às " + horario + ".");
    }

    public void receberFalhaReserva(String mensagem) {
        System.out.println("Falha na reserva: " + mensagem);
    }
}
