package estacionamento;

public class Idoso extends Vaga {
    public Idoso(String fila, int numero) {
        super(fila, numero);
        this.fatorPreco = 0.8; // Exemplo de fator de preço
    }

    @Override
    public String getTipoVaga() {
        return "Idoso";
    }
}
