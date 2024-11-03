package controller;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class ClienteController {
    private static List<Cliente> clientes = new ArrayList<>();

    public static Cliente cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
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
            return true;
        } else {
            return false;
        }
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
