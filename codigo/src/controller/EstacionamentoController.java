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
        // Filtra as vagas disponíveis do tipo selecionado
        Optional<Vaga> vagaDisponivel = estacionamento.getVagas().stream()
                .filter(vaga -> vaga.isDisponivel() && vaga.getTipo().equals(tipoDeVaga))
                .findFirst();
    
        if (vagaDisponivel.isPresent()) {
            Vaga vaga = vagaDisponivel.get();
    
            // Procura pelo veículo e cliente usando a placa
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
            
            // Gerar o recibo com os detalhes da cobrança
            String recibo = "Recibo de Cobrança\n"
                            + "Placa: " + cobranca.getVeiculo().getPlaca() + "\n"
                            + "Hora de Entrada: " + cobranca.getHoraEntrada() + "\n"
                            + "Hora de Saída: " + cobranca.getHoraSaida() + "\n"
                            + "Total a Pagar: " + cobranca.calcularValor() + "\n";
            
            return recibo;
        }
        
        return null;  // Retorna null se a cobrança não for encontrada ou o veículo não estiver estacionado
    }
    

    private Cliente buscarCliente(String idCliente) {
        return ClienteController.getClientes().stream()
                .filter(c -> c.getIdCliente().equals(idCliente))
                .findFirst()
                .orElse(null);
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }
}
