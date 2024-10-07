// src/veiculos/Cliente.java
package veiculos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String id;
    private List<Veiculo> veiculos;

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
