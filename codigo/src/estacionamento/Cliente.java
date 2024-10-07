package estacionamento;

import java.util.*;

public class Cliente {
    private String nome;
    private List<Veiculo> veiculos;
    private final int idCliente;
    private static int contadorClientes = 0;

    public Cliente(String nome) {
        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.idCliente = gerarIdCliente();
    }

    private int gerarIdCliente() {
        contadorClientes++;
        return contadorClientes;
    }

    public void registrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void mostraVeiculosDoCliente() {
    System.out.println("\nVeículos registrados para o cliente " + nome + ":");
    if (veiculos.isEmpty()) {
        System.out.println("Nenhum veículo registrado.");
    } else {
        for (Veiculo veiculo : veiculos) {
            System.out.println("Placa: " + veiculo.getPlaca());
        }
      }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
