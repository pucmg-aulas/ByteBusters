package estacionamento;

public class Vip extends Vaga {

    public Vip(String fila, int numVaga) {
        super(fila, numVaga, "VIP");
        this.fatorPreco = 1.20; // 20% mais caro
    }
}
