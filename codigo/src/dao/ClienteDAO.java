package dao;

import java.io.FileWriter;
import java.io.IOException;
import model.Cliente;

public class ClienteDAO {
    private static final String FILE_PATH = "clientes.txt";

    public void salvarCliente(Cliente cliente) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(cliente.getIdCliente() + "," + cliente.getNome() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }
}
