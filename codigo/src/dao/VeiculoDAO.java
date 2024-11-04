package dao;

import java.io.FileWriter;
import java.io.IOException;

import model.Veiculo;

public class VeiculoDAO {
    private static final String FILE_PATH = "veiculos.txt";

    public void salvarVeiculo(Veiculo veiculo) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(veiculo.getPlaca() + "," + veiculo.getProprietario().getIdCliente() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar veículo: " + e.getMessage());
        }
    }
}
