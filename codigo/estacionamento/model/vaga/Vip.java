package estacionamento;

public class Vip extends Vaga {
    public Vip(String fila, int numero) {
        super(fila, numero);
        this.fatorPreco = 1.5; // Exemplo de fator de preço
    }

    @Override
    public String getTipoVaga() {
        return "VIP";
    }
}
