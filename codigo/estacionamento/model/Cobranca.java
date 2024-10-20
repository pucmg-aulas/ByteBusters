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
        this.horaChegada = horaChegada; // Armazena a hora de chegada
    }

    public void registrarSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
        double valor = calcularValor();
        gravarRelatorio(valor);
    }

    private double calcularValor() {
        long tempoEstacionado = horaSaida.getTime() - horaChegada.getTime();
        double horasEstacionadas = Math.ceil((tempoEstacionado / (1000 * 60)) / 15.0);
        double valor = horasEstacionadas * PRECO15MIN * vaga.getFatorPreco(); // Aplicar fator de preço
        return Math.min(valor, PRECOMAX);
    }

    private void gravarRelatorio(double valor) {
        try (FileWriter writer = new FileWriter(NOME_ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            bw.write("Veículo: " + veiculo.getPlaca() + ", Vaga: " + vaga.getId() +
                    ", Hora Chegada: " + sdf.format(horaChegada) +
                    ", Hora Saída: " + sdf.format(horaSaida) +
                    ", Valor Cobrado: R$ " + valor);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao gravar relatório: " + e.getMessage());
        }
    }

    public static void lerRelatorio() {
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler relatório: " + e.getMessage());
        }
    }
}
