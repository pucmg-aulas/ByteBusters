package estacionamento;

public class Idoso extends Vaga {

    public Idoso(String fila, int numVaga) {
        super(fila, numVaga, "Idoso");
        this.fatorPreco = 0.85; // 15% de desconto
    }
}
