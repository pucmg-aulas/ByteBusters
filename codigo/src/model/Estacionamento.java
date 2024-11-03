package model;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private String nome;
    private String endereco;
    private int totalVagas;
    private List<Vaga> vagas;

    public Estacionamento(String nome, String endereco, int totalVagas) {
        this.nome = nome;
        this.endereco = endereco;
        this.totalVagas = totalVagas;
        this.vagas = new ArrayList<>();
        inicializarVagas();
    }

    private void inicializarVagas() {
        int vagasPcd = (int) (totalVagas * 0.1);
        int vagasIdoso = (int) (totalVagas * 0.1);
        int vagasVip = (int) (totalVagas * 0.2);
        int vagasNormais = totalVagas - (vagasPcd + vagasIdoso + vagasVip);

        for (int i = 0; i < vagasPcd; i++) vagas.add(new VagaPcd());
        for (int i = 0; i < vagasIdoso; i++) vagas.add(new VagaIdoso());
        for (int i = 0; i < vagasVip; i++) vagas.add(new VagaVip());
        for (int i = 0; i < vagasNormais; i++) vagas.add(new VagaNormal());
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

}
