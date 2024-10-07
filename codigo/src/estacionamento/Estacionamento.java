package estacionamento;

import java.util.ArrayList;
import java.util.List;
import vagas.Vaga;
import veiculos.Veiculo;

public class Estacionamento {
    private String nome;
    private List<Vaga> vagas;
    private List<Veiculo> veiculosEstacionados;

    public Estacionamento(String nome) {
        this.nome = nome;
        this.vagas = new ArrayList<>();
        this.veiculosEstacionados = new ArrayList<>();
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public boolean estacionarVeiculo(Veiculo veiculo, String idVaga) {
        for (Vaga vaga : vagas) {
            if (vaga.getId().equals(idVaga) && !vaga.isOcupada()) {
                vaga.ocuparVaga(veiculo);
                veiculo.setVagaId(idVaga);
                veiculosEstacionados.add(veiculo);
                return true;
            }
        }
        return false;
    }

    public boolean liberarVaga(String idVaga) {
        for (Vaga vaga : vagas) {
            if (vaga.getId().equals(idVaga) && vaga.isOcupada()) {
                vaga.liberarVaga();
                veiculosEstacionados.removeIf(veiculo -> veiculo.getVagaId().equals(idVaga));
                return true;
            }
        }
        return false;
    }

    public void limparVagas() {
        this.vagas.clear();
    }
    
}
