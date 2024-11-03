package model;

public abstract class Vaga {
    private boolean disponivel;

    public Vaga() {
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void ocupar() {
        this.disponivel = false;
    }

    public void desocupar() {
        this.disponivel = true;
    }

    public abstract double getFatorPreco();
}

class VagaPcd extends Vaga {
    @Override
    public double getFatorPreco() {
        return 0.8;  // 20% de desconto
    }
}

class VagaIdoso extends Vaga {
    @Override
    public double getFatorPreco() {
        return 0.9;  // 10% de desconto
    }
}

class VagaVip extends Vaga {
    @Override
    public double getFatorPreco() {
        return 1.2;  // 20% de acréscimo
    }
}

class VagaNormal extends Vaga {
    @Override
    public double getFatorPreco() {
        return 1.0;  // Sem desconto ou acréscimo
    }
}
