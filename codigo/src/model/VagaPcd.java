package model;

public class VagaPcd extends Vaga {
    @Override
    public double getFatorPreco() {
        return 0.8;  // 20% de desconto
    }

    @Override
    public String getTipo() {
        return "Pcd";
    }
}
