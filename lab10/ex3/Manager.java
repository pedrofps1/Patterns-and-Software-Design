import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class GerenteRestaurante {
    private List<Tabela> mesasDisponiveis;

    public GerenteRestaurante() {
        mesasDisponiveis = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            mesasDisponiveis.add(new Tabela(i));
        }
    }

    public void reservarMesa(Cliente cliente, int numeroMesa, LocalDateTime horario) {
        Tabela mesa = encontrarMesaDisponivel(numeroMesa);
        if (mesa != null) {
            mesa.reservar(cliente, horario);
        } else {
            cliente.receberFalhaReserva("Mesa " + numeroMesa + " não está disponível.");
        }
    }

    private Tabela encontrarMesaDisponivel(int numeroMesa) {
        for (Tabela mesa : mesasDisponiveis) {
            if (mesa.getNumero() == numeroMesa && !mesa.isReservada()) {
                return mesa;
            }
        }
        return null;
    }
}
