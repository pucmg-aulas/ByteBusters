package estacionamento;

public class Pcd extends Vaga {
    public Pcd(String fila, int numero) {
        super(fila, numero);
        this.fatorPreco = 0.5; // Exemplo de fator de preço
    }

    @Override
    public String getTipoVaga() {
        return "PCD";
    }
}
