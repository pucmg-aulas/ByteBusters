package dao;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import model.Cobranca;

public class CobrancaDAO {
    private static final String FILE_PATH = "cobrancas.txt";

    public void salvarCobranca(Cobranca cobranca) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(
                cobranca.getVeiculo().getPlaca() + "," +
                cobranca.getHoraEntrada().format(formatter) + "," +
                cobranca.getHoraSaida().format(formatter) + "," +
                cobranca.calcularValor() + "\n"
            );
        } catch (IOException e) {
            System.out.println("Erro ao salvar cobrança: " + e.getMessage());
        }
    }
}
