package estacionamento;

public class Vaga {
    protected String id;
    protected String fila;
    protected int numVaga;
    protected boolean disponivel;
    protected double fatorPreco = 1.0;  
    public Vaga(String fila, int numVaga) {
        this.fila = fila;
        this.numVaga = numVaga;
        this.disponivel = true;
        calcularID(fila, numVaga);
    }

    public void calcularID(String fila, int numVaga) {
        this.id = fila + String.format("%02d", numVaga);
    }

    public String getId() {
        return id;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void ocupaVaga() {
        this.disponivel = false;
    }

    public void desocupaVaga() {
        this.disponivel = true;
    }

    public double getFatorPreco() {
        return fatorPreco;
    }
}
