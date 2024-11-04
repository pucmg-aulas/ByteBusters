package model;

class VagaVip extends Vaga {
    @Override
    public double getFatorPreco() {
        return 1.2;  // 20% de acréscimo
    }
}
