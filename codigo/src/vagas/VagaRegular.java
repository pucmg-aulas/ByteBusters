// src/vagas/VagaRegular.java
package vagas;

public class VagaRegular extends Vaga {
    public VagaRegular(String id) {
        super(id);
    }

    @Override
    public double calcularPreco(int minutos) {
        return Math.min((minutos / 15) * 4.0, 50.0);
    }
}
