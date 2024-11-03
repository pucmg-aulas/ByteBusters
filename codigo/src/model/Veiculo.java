package model;

public class Veiculo {
    private String placa;
    private Cliente proprietario;

    public Veiculo(String placa, Cliente proprietario) {
        this.placa = placa;
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public Cliente getProprietario() {
        return proprietario;
    }
}
