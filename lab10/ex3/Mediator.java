import java.time.LocalDateTime;

interface Mediator {
    void fazerReserva(Cliente cliente, int numeroMesa, LocalDateTime horario);
}   