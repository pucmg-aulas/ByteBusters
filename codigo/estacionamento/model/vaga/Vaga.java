package estacionamento;

import java.io.Serializable;
import java.util.Date;

public abstract class Vaga {
    private String id;
    private boolean disponivel;
    protected double fatorPreco; // Fator de preço
    private Veiculo veiculo; // Referência ao veículo
    private Date horaChegada; // Hora de chegada do veículo

    public Vaga(String fila, int numero) {
        this.id = fila + String.format("%02d", numero);
        this.disponivel = true;
        this.fatorPreco = 1.0; // Valor padrão
    }

    public abstract String getTipoVaga(); // Método abstrato para ser sobrescrito

    public String getId() {
        return id;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void ocupaVaga(Veiculo veiculo) {
        this.veiculo = veiculo; // Atribui o veículo à vaga
        this.disponivel = false;
        this.horaChegada = new Date(); // Armazena a hora de chegada
    }

    public void desocupaVaga() {
        this.veiculo = null; // Remove o veículo da vaga
        this.disponivel = true;
        this.horaChegada = null; // Reseta a hora de chegada
    }

    public Veiculo getVeiculo() {
        return veiculo; // Método para obter o veículo associado
    }

    public double getFatorPreco() {
        return fatorPreco; // Método para obter o fator de preço
    }

    public Date getHoraChegada() {
        return horaChegada; // Método para obter a hora de chegada
    }
}
