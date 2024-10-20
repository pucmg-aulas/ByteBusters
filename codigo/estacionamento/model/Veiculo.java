package estacionamento;

import java.io.Serializable;

public class Veiculo implements Serializable {
    private String placa;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
}