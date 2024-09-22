import java.util.Date;
package estacionamento;

public class Cobranca {

    private Date horaChegada;
    private Date horaSaida;
    private final double PRECO15MIN = 4.00;
    private final double PRECOMAX = 50.00;

    public Cobranca(Date horaChegada, Date horaSaida) {
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
    }

    public double calculaTempoOcupacao() {
        long diferencaEmMilissegundos = horaSaida.getTime() - horaChegada.getTime();
        double diferencaEmMinutos = (diferencaEmMilissegundos / 1000.0) / 60.0;
        return diferencaEmMinutos;
    }

    public double calculaValorTotal() {
        double tempoOcupacao = calculaTempoOcupacao();
        double valorTotal;

        // Cálculo do valor a ser cobrado
        if (tempoOcupacao <= 15) {
            valorTotal = PRECO15MIN;
        } else if (tempoOcupacao > 15 && tempoOcupacao <= 120) { // 120 minutos é o equivalente a 2 horas
            valorTotal = Math.ceil(tempoOcupacao / 15) * PRECO15MIN;
        } else {
            valorTotal = PRECOMAX;
        }

        return valorTotal;
    }

    public void efetuarPagamento() {
        double valorTotal = calculaValorTotal();
        System.out.println("Valor total a ser pago: R$ " + valorTotal);
        // Implementar lógica para o pagamento
    }

    // Getters e setters
    public Date getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Date horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }
}

}
