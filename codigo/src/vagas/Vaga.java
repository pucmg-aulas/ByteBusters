package vagas;

import veiculos.Veiculo;

public abstract class Vaga {
    protected String id;
    protected boolean ocupada;
    protected Veiculo veiculo;

    public Vaga(String id) {
        this.id = id;
        this.ocupada = false;
    }

    public String getId() {
        return id;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocuparVaga(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.ocupada = true;
    }

    public void liberarVaga() {
        this.veiculo = null;
        this.ocupada = false;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public abstract double calcularPreco(int minutos);
}
