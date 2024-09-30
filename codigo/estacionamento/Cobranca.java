package estacionamento;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cobranca {

    private Date horaChegada;
    private Date horaSaida;
    private final double PRECO15MIN = 4.00;
    private final double PRECOMAX = 50.00;
    private Veiculo veiculo;
    private Cliente cliente;
    private Vaga vaga;

    public Cobranca(Veiculo veiculo, Cliente cliente, Vaga vaga) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.vaga = vaga;
    }

    public double calculaTempoOcupacao() {
        long diferencaEmMilissegundos = horaSaida.getTime() - horaChegada.getTime();
        double diferencaEmMinutos = (diferencaEmMilissegundos / 1000.0) / 60.0;
        return diferencaEmMinutos;
    }

    public double calculaValorTotal() {
    double tempoOcupacao = calculaTempoOcupacao();
    double valorTotal;

    if (tempoOcupacao <= 15) {
        valorTotal = PRECO15MIN;
    } else if (tempoOcupacao > 15 && tempoOcupacao <= 180) {
        valorTotal = Math.ceil(tempoOcupacao / 15) * PRECO15MIN;
    } else {
        valorTotal = PRECOMAX;
    }

    valorTotal *= vaga.getFatorPreco();

    return valorTotal;
}


    public void efetuarPagamento() {
        if (vaga != null) {
            vaga.desocupar();
        }
    }

    public void mostrarCobranca() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("HH:mm:ss");
        String chegadaFormatada = dataFormatada.format(horaChegada);
        String saidaFormatada = dataFormatada.format(horaSaida);

        System.out.println("\nCliente: " + cliente.getNome());
        System.out.println("Placa do veículo: " + veiculo.getPlaca());
        System.out.println("Vaga utilizada: " + vaga.getNumero());
        System.out.println("Hora de chegada: " + chegadaFormatada);
        System.out.println("Hora de saída: " + saidaFormatada);
        System.out.println("Tempo de ocupação: " + calculaTempoOcupacao() + " minutos");
        System.out.println("Valor total a ser pago: R$ " + calculaValorTotal());
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}
