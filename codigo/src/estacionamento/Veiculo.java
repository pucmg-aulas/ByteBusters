package estacionamento;

public class Veiculo {
    private final String placa;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public void mostrarVeiculo() {
        System.out.println("\nVeículo placa: " + placa);
    }

    public String getPlaca() {
        return placa;
    }
}
