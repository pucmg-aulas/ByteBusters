// src/vagas/VagaVIP.java
package vagas;

public class VagaVIP extends Vaga {
    public VagaVIP(String id) {
        super(id);
    }

    @Override
    public double calcularPreco(int minutos) {
        return Math.min((minutos / 15) * 4.0 * 1.20, 50.0);
    }
}
