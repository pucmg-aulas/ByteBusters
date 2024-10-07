package estacionamento;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Estacionamento estacionamento1 = new Estacionamento("Estacionamento A", "Rua A");
        estacionamento1.mostrarEstacionamento();

        estacionamento1.adicionarVaga("A", 1);
        estacionamento1.adicionarVaga("A", 2);
        estacionamento1.adicionarVaga("B", 1);
        estacionamento1.adicionarVaga("B", 2);
        estacionamento1.mostrarVagas();
        
        Cliente cliente1 = new Cliente("João");
        Veiculo veiculo1 = new Veiculo("AAA-1111");
        Veiculo veiculo2 = new Veiculo("BBB-2222");
        
        cliente1.registrarVeiculo(veiculo1);
        cliente1.registrarVeiculo(veiculo2);
        cliente1.mostraVeiculosDoCliente();
        
        Vaga vagaDisponivel = estacionamento1.getVagas().get(0);
        veiculo1.associarVaga(vagaDisponivel);
        veiculo1.mostrarVeiculo();
      
        estacionamento1.mostrarVagas();
        
        // Criando uma cobrança para o veículo 1 com a horaChegada atual e horaSaida (1hr e 30min depois) na própria instância
        Cobranca cobrancaVeiculo1 = new Cobranca(veiculo1, new Date(), new Date(new Date().getTime() + (90 * 60 * 1000)));

        cobrancaVeiculo1.mostrarCobranca();

        cobrancaVeiculo1.efetuarPagamento();
        
        veiculo1.mostrarVeiculo();
        estacionamento1.mostrarVagas();
    }
}
