package estacionamento;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cobranca {
    private Date horaChegada;
    private Date horaSaida;
    private final double PRECO15MIN = 4.00;
    private final double PRECOMAX = 50.00;
    private Veiculo veiculo;
    private Vaga vaga;
    private static final String NOME_ARQUIVO = "relatorio_cobrancas.txt";

    public Cobranca(Veiculo veiculo, Vaga vaga, Date horaChegada) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horaChegada = horaChegada;
    }

    public void registrarSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
        escreverRelatorio();
    }

    public int calculaTempoOcupacao() {
        long diferencaEmMilissegundos = horaSaida.getTime() - horaChegada.getTime();
        return (int) ((diferencaEmMilissegundos / 1000.0) / 60.0);
    }

    public double calculaValorTotal() {
        double tempoOcupacao = calculaTempoOcupacao();
        double precoBase;

        if (tempoOcupacao <= 15) {
            precoBase = PRECO15MIN;
        } else if (tempoOcupacao <= 180) {
            precoBase = Math.ceil(tempoOcupacao / 15) * PRECO15MIN;
        } else {
            precoBase = PRECOMAX;
        }

        precoBase *= vaga.getFatorPreco();

        return precoBase;
    }

    public void mostrarCobranca() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("HH:mm:ss"); // Formato hora:minuto:segundo
        String chegadaFormatada = dataFormatada.format(horaChegada);
        String saidaFormatada = dataFormatada.format(horaSaida);

        System.out.println("\nPlaca do veículo: " + veiculo.getPlaca());
        System.out.println("Vaga: " + vaga.getId());
        System.out.println("Hora de chegada: " + chegadaFormatada);
        System.out.println("Hora de saída: " + saidaFormatada);
        System.out.println("Tempo de ocupação: " + calculaTempoOcupacao() + " minutos");
        System.out.println("Valor total a ser pago: R$ " + calculaValorTotal());
    }

    private void escreverRelatorio() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("HH:mm:ss");
        String chegadaFormatada = dataFormatada.format(horaChegada);
        String saidaFormatada = dataFormatada.format(horaSaida);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.write("Placa do veículo: " + veiculo.getPlaca());
            writer.newLine();
            writer.write("Vaga: " + vaga.getId());
            writer.newLine();
            writer.write("Hora de chegada: " + chegadaFormatada);
            writer.newLine();
            writer.write("Hora de saída: " + saidaFormatada);
            writer.newLine();
            writer.write("Tempo de ocupação: " + calculaTempoOcupacao() + " minutos");
            writer.newLine();
            writer.write("Valor total a ser pago: R$ " + calculaValorTotal());
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void lerRelatorio() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }
}
