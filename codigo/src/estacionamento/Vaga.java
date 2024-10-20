package estacionamento;

public abstract class Vaga {
    private String id;
    private boolean disponivel;
    protected double fatorPreco; // Fator de preço
    private Veiculo veiculo; // Referência ao veículo

    public Vaga(String fila, int numero) {
        this.id = fila + String.format("%02d", numero);
        this.disponivel = true;
        this.fatorPreco = 1.0; // Valor padrão
    }

    public abstract String getTipoVaga(); // Método abstrato para ser sobrescrito

    public String getId() {
        return id;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void ocupaVaga(Veiculo veiculo) {
        this.veiculo = veiculo; // Atribui o veículo à vaga
        this.disponivel = false;
    }

    public void desocupaVaga() {
        this.veiculo = null; // Remove o veículo da vaga
        this.disponivel = true;
    }

    public Veiculo getVeiculo() {
        return veiculo; // Método para obter o veículo associado
    }

    public double getFatorPreco() {
        return fatorPreco; // Método para obter o fator de preço
    }
}
