package estacionamento;

public abstract class Vaga {
    private String id;
    private String fila;
    private int numVaga;
    private boolean disponivel;
    protected double fatorPreco;
    private String tipoVaga;

    public Vaga(String fila, int numVaga, String tipoVaga) {
        this.fila = fila;
        this.numVaga = numVaga;
        this.disponivel = true;
        this.tipoVaga = tipoVaga;
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

    public String getTipoVaga() {
        return tipoVaga;
    }
}
