package model;

class VagaIdoso extends Vaga {
    @Override
    public double getFatorPreco() {
        return 0.9;  // 10% de desconto
    }

    @Override
    public String getTipo() {
        return "Idoso";
    }
}
