package estacionamento;

public class Veiculo {
    private final String placa;
    private Vaga vagaAtual;

    public Veiculo(String placa) {
        this.placa = placa;
        this.vagaAtual = null;
    }

    public void associarVaga(Vaga vaga) {
        this.vagaAtual = vaga;
        vaga.ocupaVaga(); 
    }

    public void removeVaga() {
        if (this.vagaAtual != null) {
            this.vagaAtual.desocupaVaga();
            this.vagaAtual = null;
        }
    }

    public void mostrarVeiculo() {
        System.out.println("\nVeículo placa: " + placa);
        if (vagaAtual != null) {
            System.out.println("Estacionado na vaga: " + vagaAtual.getId());
        } else {
            System.out.println("O veículo não está estacionado.");
        }
    }
    
    public String getPlaca() {
        return placa;
    }

    public Vaga getVagaAtual() {
        return vagaAtual;
    }
}

