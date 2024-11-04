package controller;

import java.time.LocalDateTime;
import java.util.*;
import model.*;

public class EstacionamentoController {
    private Estacionamento estacionamento;

    public void criarEstacionamento(String nome, String endereco, int totalVagas) {
        this.estacionamento = new Estacionamento(nome, endereco, totalVagas);
    }

    public boolean ocuparVaga(String placa, String tipoDeVaga) {
        Optional<Vaga> vagaDisponivel = estacionamento.getVagas().stream()
                .filter(vaga -> vaga.isDisponivel() && vaga.getTipo().equals(tipoDeVaga))
                .findFirst();
    
        if (vagaDisponivel.isPresent()) {
            Vaga vaga = vagaDisponivel.get();
    
            Optional<Cliente> clienteOpt = ClienteController.getClientes().stream()
                    .filter(cliente -> cliente.getVeiculos().stream()
                            .anyMatch(veiculo -> veiculo.getPlaca().equals(placa)))
                    .findFirst();
    
            if (clienteOpt.isPresent()) {
                Cliente cliente = clienteOpt.get();
                Veiculo veiculo = cliente.getVeiculos().stream()
                        .filter(v -> v.getPlaca().equals(placa))
                        .findFirst()
                        .orElse(null);
    
                if (veiculo != null) {
                    vaga.ocupar();
                    Cobranca cobranca = new Cobranca(veiculo, vaga, LocalDateTime.now());
                    CobrancaController.adicionarCobranca(cobranca);
                    return true;
                }
            }
        }
        return false;
    }
    

    public String desocuparVaga(String placa) {
        Cobranca cobranca = CobrancaController.buscarCobrancaAtivaPorPlaca(placa);
        
        if (cobranca != null) {
            cobranca.registrarSaida(LocalDateTime.now());
            cobranca.getVaga().desocupar();
            
            String recibo = "Recibo de Cobrança\n"
                            + "Placa: " + cobranca.getVeiculo().getPlaca() + "\n"
                            + "Hora de Entrada: " + cobranca.getHoraEntrada() + "\n"
                            + "Hora de Saída: " + cobranca.getHoraSaida() + "\n"
                            + "Total a Pagar: " + cobranca.calcularValor() + "\n";
            
            return recibo;
        }
        
        return null;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }
}
