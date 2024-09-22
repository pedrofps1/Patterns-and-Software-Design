import java.time.LocalDateTime;

public class Tabela {
    private int numero;
    private boolean reservada;
    private Cliente clienteReserva;
    private LocalDateTime horarioReserva;

    public Tabela(int numero) {
        this.numero = numero;
        this.reservada = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void reservar(Cliente cliente, LocalDateTime horario) {
        reservada = true;
        clienteReserva = cliente;
        horarioReserva = horario;
        cliente.receberConfirmacaoReserva(numero, horario);
    }    
}
