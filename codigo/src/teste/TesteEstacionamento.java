// src/teste/TesteEstacionamento.java
package teste;

import estacionamento.Estacionamento;
import vagas.VagaIdoso;
import vagas.VagaPCD;
import vagas.VagaRegular;
import vagas.VagaVIP;
import veiculos.Veiculo;
import tickets.TicketEstacionamento;

public class TesteEstacionamento {
    public static void main(String[] args) {
        // Criar estacionamento
        Estacionamento estacionamento = new Estacionamento("Estacionamento Central");

        // Adicionar vagas ao estacionamento
        estacionamento.adicionarVaga(new VagaRegular("R01"));
        estacionamento.adicionarVaga(new VagaVIP("V01"));
        estacionamento.adicionarVaga(new VagaIdoso("I01"));
        estacionamento.adicionarVaga(new VagaPCD("P01"));

        // Criar veículos
        Veiculo veiculo1 = new Veiculo("ABC-1234", "C01");  // Cliente 1
        Veiculo veiculo2 = new Veiculo("DEF-5678", "C02");  // Cliente 2
        Veiculo veiculo3 = new Veiculo("GHI-9012", "C03");  // Cliente 3

        // Testar ocupação de vagas
        System.out.println(">>> Estacionando veículos...");
        boolean estacionado1 = estacionamento.estacionarVeiculo(veiculo1, "R01");
        boolean estacionado2 = estacionamento.estacionarVeiculo(veiculo2, "V01");
        boolean estacionado3 = estacionamento.estacionarVeiculo(veiculo3, "I01");

        System.out.println("Veículo 1 estacionado em vaga regular: " + estacionado1);
        System.out.println("Veículo 2 estacionado em vaga VIP: " + estacionado2);
        System.out.println("Veículo 3 estacionado em vaga para idoso: " + estacionado3);

        // Criar tickets de estacionamento com tempo de entrada
        TicketEstacionamento ticket1 = new TicketEstacionamento("R01", veiculo1, System.currentTimeMillis());
        TicketEstacionamento ticket2 = new TicketEstacionamento("V01", veiculo2, System.currentTimeMillis());
        TicketEstacionamento ticket3 = new TicketEstacionamento("I01", veiculo3, System.currentTimeMillis());

        // Simular tempo de permanência
        try {
            Thread.sleep(3000);  // Simula 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Saída dos veículos e cálculo de tarifas
        System.out.println("\n>>> Liberando vagas e calculando tarifas...");
        long horaSaida = System.currentTimeMillis();  // Tempo de saída

        estacionamento.liberarVaga("R01");
        ticket1.registrarSaida(horaSaida);
        double preco1 = ticket1.calcularPrecoTotal(estacionamento.getVagas().get(0));
        System.out.println("Preço para veículo 1 (vaga regular): R$" + preco1);

        estacionamento.liberarVaga("V01");
        ticket2.registrarSaida(horaSaida);
        double preco2 = ticket2.calcularPrecoTotal(estacionamento.getVagas().get(1));
        System.out.println("Preço para veículo 2 (vaga VIP): R$" + preco2);

        estacionamento.liberarVaga("I01");
        ticket3.registrarSaida(horaSaida);
        double preco3 = ticket3.calcularPrecoTotal(estacionamento.getVagas().get(2));
        System.out.println("Preço para veículo 3 (vaga idoso): R$" + preco3);

        // Verificar liberação
        System.out.println("\n>>> Verificando se as vagas foram liberadas...");
        boolean liberada1 = !estacionamento.getVagas().get(0).isOcupada();
        boolean liberada2 = !estacionamento.getVagas().get(1).isOcupada();
        boolean liberada3 = !estacionamento.getVagas().get(2).isOcupada();

        System.out.println("Vaga regular liberada: " + liberada1);
        System.out.println("Vaga VIP liberada: " + liberada2);
        System.out.println("Vaga idoso liberada: " + liberada3);
    }
}
