package estacionamento;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private String nome;
    private String endereco;
    private List<Vaga> vagas;

    public Estacionamento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.vagas = new ArrayList<>();
        inicializarVagas(); // Chama o método para inicializar as vagas
    }

    private void inicializarVagas() {
        // Criar 10 Vagas Normais
        for (int i = 1; i <= 10; i++) {
            vagas.add(new Normal("A", i));
        }

        // Criar 5 Vagas VIP
        for (int i = 1; i <= 5; i++) {
            vagas.add(new Vip("B", i));
        }

        // Criar 5 Vagas PCD
        for (int i = 1; i <= 5; i++) {
            vagas.add(new Pcd("C", i));
        }

        // Criar 5 Vagas Idoso
        for (int i = 1; i <= 5; i++) {
            vagas.add(new Idoso("D", i));
        }
    }

    public void mostrarEstacionamento() {
        System.out.println("Nome do Estacionamento: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Total de Vagas: " + vagas.size());
        System.out.println("Vagas Ocupadas: " + (vagas.size() - (int) vagas.stream().filter(Vaga::estaDisponivel).count()));
    }

    public void mostrarVagas() {
        for (Vaga vaga : vagas) {
            System.out.println("ID da Vaga: " + vaga.getId() +
                    ", Tipo: " + vaga.getTipoVaga() +
                    ", Disponível: " + vaga.estaDisponivel());
        }
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public List<Vaga> getVagas() {
        return vagas;
    }
}
