package estacionamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private static int contador = 0;
    private int idCliente;
    private String nome;
    private List<Veiculo> veiculos;

    public Cliente(String nome) {
        this.idCliente = ++contador;
        this.nome = nome;
        this.veiculos = new ArrayList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void registrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public static void atualizarContador(int maxId) {
        if (maxId > contador) {
            contador = maxId;
        }
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}