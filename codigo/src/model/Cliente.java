package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int contadorId = 1;
    private String nome;
    private String idCliente;
    private List<Veiculo> veiculos;

    public Cliente(String nome) {
        this.nome = nome;
        this.idCliente = String.format("%04d", contadorId++);
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public String getIdCliente() {
        return idCliente;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

}
