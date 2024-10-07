// src/tickets/TicketEstacionamento.java
package tickets;

import vagas.Vaga;
import veiculos.Veiculo;

public class TicketEstacionamento {
    private String idVaga;
    private Veiculo veiculo;
    private long horaEntrada;
    private long horaSaida;

    public TicketEstacionamento(String idVaga, Veiculo veiculo, long horaEntrada) {
        this.idVaga = idVaga;
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
    }

    public void registrarSaida(long horaSaida) {
        this.horaSaida = horaSaida;
    }

    public double calcularPrecoTotal(Vaga vaga) {
        int totalMinutos = (int) ((horaSaida - horaEntrada) / 60000); // Convertendo milissegundos para minutos
        return vaga.calcularPreco(totalMinutos);
    }
}
