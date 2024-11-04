package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dao.VeiculoDAO;
import model.*;

public class ClienteController {
    private static List<Cliente> clientes = new ArrayList<>();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static VeiculoDAO veiculoDAO = new VeiculoDAO();

    public static Cliente cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);

        // Salvar o cliente no arquivo
        clienteDAO.salvarCliente(cliente);

        return cliente;
    }

    public static boolean cadastrarVeiculo(String idCliente, String placa) {
        Cliente cliente = clientes.stream()
                .filter(c -> c.getIdCliente().equals(idCliente))
                .findFirst()
                .orElse(null);

        if (cliente != null) {
            Veiculo veiculo = new Veiculo(placa, cliente);
            cliente.adicionarVeiculo(veiculo);

            // Salvar o veículo no arquivo
            veiculoDAO.salvarVeiculo(veiculo);

            return true;
        } else {
            return false;
        }
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
