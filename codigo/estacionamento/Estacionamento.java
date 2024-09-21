package estacionamento;

import java.util.*;

public class Estacionamento {
    private String nome;
    private String endereco;
    private int quantVagas;
    private List<Vaga> vagas;

    public Estacionamento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.vagas = new ArrayList<>();
    }
    
    public List<Vaga> getVagas() {
        return vagas;
    }

    public void adicionarVaga(String fila, int numVaga) {
        Vaga vaga = new Vaga(fila, numVaga);
        vagas.add(vaga);
        quantVagas = vagas.size();
    }

    public void mostrarVagas() {
        System.out.println("\nVagas no Estacionamento " + nome + ":");
        for (Vaga vaga : vagas) {
            System.out.println("Vaga ID: " + vaga.getId() + " - Disponível: " + (vaga.estaDisponivel() ? "Sim" : "Não"));
        }
    }
    
    public void mostrarEstacionamento() {
        System.out.println("\nNome do Estacionamento: " + nome + ", Endereço: " + endereco + ", Quantidade de Vagas: " + quantVagas + "");
    }
}
