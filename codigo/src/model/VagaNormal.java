package model;

class VagaNormal extends Vaga {
    @Override
    public double getFatorPreco() {
        return 1.0;  // Sem desconto ou acréscimo
    }

    @Override
    public String getTipo() {
        return "Normal";
    }
}
