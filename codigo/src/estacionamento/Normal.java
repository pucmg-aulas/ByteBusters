package estacionamento;

public class Normal extends Vaga {

    public Normal(String fila, int numVaga) {
        super(fila, numVaga, "Normal");
        this.fatorPreco = 1.0;
    }
}
