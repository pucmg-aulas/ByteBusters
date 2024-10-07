package estacionamento;

public class Pcd extends Vaga {

    public Pcd(String fila, int numVaga) {
        super(fila, numVaga, "PCD");
        this.fatorPreco = 0.87; // 13% de desconto
    }
}
