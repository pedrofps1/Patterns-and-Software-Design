import java.time.LocalDateTime;

class SistemaReservasMediator implements Mediator {
    private GerenteRestaurante gerenteRestaurante;

    public void setGerenteRestaurante(GerenteRestaurante gerenteRestaurante) {
        this.gerenteRestaurante = gerenteRestaurante;
    }

    @Override
    public void fazerReserva(Cliente cliente, int numeroMesa, LocalDateTime horario) {
        gerenteRestaurante.reservarMesa(cliente, numeroMesa, horario);
    }
}