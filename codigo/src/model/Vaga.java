package model;

public abstract class Vaga {
    private boolean disponivel;

    public Vaga() {
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void ocupar() {
        this.disponivel = false;
    }

    public void desocupar() {
        this.disponivel = true;
    }

    public abstract double getFatorPreco();

    public abstract String getTipo();
}
