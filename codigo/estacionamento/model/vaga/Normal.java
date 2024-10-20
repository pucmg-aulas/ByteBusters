package estacionamento;

public class Normal extends Vaga {
    public Normal(String fila, int numero) {
        super(fila, numero);
    }

    @Override
    public String getTipoVaga() {
        return "Normal";
    }
}
