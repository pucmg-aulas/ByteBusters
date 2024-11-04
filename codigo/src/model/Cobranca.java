package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cobranca {
    private Veiculo veiculo;
    private Vaga vaga;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Cobranca(Veiculo veiculo, Vaga vaga, LocalDateTime horaEntrada) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horaEntrada = horaEntrada;
    }

    public void registrarSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public double calcularValor() {
        if (horaSaida == null) {
            throw new IllegalStateException("A hora de saída não foi registrada.");
        }
        
        Duration duracao = Duration.between(horaEntrada, horaSaida);
        long minutos = duracao.toMinutes();
        double valorBase = (minutos / 15) * 4;  // R$4 a cada 15 minutos
        double valorFinal = valorBase * vaga.getFatorPreco();

        return Math.min(valorFinal, 50);  // Limite de R$50
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public Vaga getVaga() {
        return vaga;
    }
}
