// src/vagas/VagaIdoso.java
package vagas;

public class VagaIdoso extends Vaga {
    public VagaIdoso(String id) {
        super(id);
    }

    @Override
    public double calcularPreco(int minutos) {
        return Math.min((minutos / 15) * 4.0 * 0.85, 50.0);
    }
}
