package estacionamento;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estacionamento a = new Estacionamento("Estacionamento A", "Rua A");

        Vaga A01 = new Normal("A", 1);
        Vaga A02 = new Normal("A", 2);
        Vaga A03 = new Idoso("A", 3);
        
        Vaga B01 = new Normal("B", 1);
        Vaga B02 = new Normal("B", 2);
        Vaga B03 = new Pcd("B", 3);
        
        Vaga C01 = new Normal("C", 1);
        Vaga C02 = new Normal("C", 2);
        Vaga C03 = new Vip("C", 3);

        a.adicionarVaga(A01);
        a.adicionarVaga(A02);
        a.adicionarVaga(A03);
        a.adicionarVaga(B01);
        a.adicionarVaga(B02);
        a.adicionarVaga(B03);
        a.adicionarVaga(C01);
        a.adicionarVaga(C02);
        a.adicionarVaga(C03);

        // Lista de cobranças ativas
        List<Cobranca> cobrancas = new ArrayList<>();

        Cliente joao = new Cliente("João");
        Veiculo veiculoJoao1 = new Veiculo("AAA1111");
        Veiculo veiculoJoao2 = new Veiculo("BBB2222");
        joao.registrarVeiculo(veiculoJoao1);
        joao.registrarVeiculo(veiculoJoao2);

        Cliente maria = new Cliente("Maria");
        Veiculo veiculoMaria1 = new Veiculo("CCC3333");
        maria.registrarVeiculo(veiculoMaria1);

        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Mostrar vagas");
            System.out.println("2. Ocupar vaga");
            System.out.println("3. Desocupar vaga e executar cobrança");
            System.out.println("4. Mostrar relatório");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Mostrar vagas
                    a.mostrarEstacionamento();
                    a.mostrarVagas();
                    break;

                case 2:
                    // Ocupar vaga
                    System.out.println("Escolha o cliente:");
                    System.out.println("" + joao.getIdCliente() + ". " + joao.getNome());
                    System.out.println("" + maria.getIdCliente() + ". " + maria.getNome());

                    int clienteOpcao = scanner.nextInt();
                    Cliente clienteSelecionado = clienteOpcao == joao.getIdCliente() ? joao : maria;

                    clienteSelecionado.mostraVeiculosDoCliente();
                    System.out.println("Escolha o veículo pelo número da placa:");
                    String placaEscolhida = scanner.next().toUpperCase();

                    Veiculo veiculoEscolhido = clienteSelecionado.getVeiculos().stream()
                        .filter(v -> v.getPlaca().equals(placaEscolhida))
                        .findFirst().orElse(null);

                    if (veiculoEscolhido == null) {
                        System.out.println("Veículo não encontrado.");
                        break;
                    }

                    System.out.println("Escolha o tipo de vaga:");
                    System.out.println("1. Normal");
                    System.out.println("2. Idoso");
                    System.out.println("3. PCD");
                    System.out.println("4. VIP");

                    int tipoVagaOpcao = scanner.nextInt();
                    String tipoVagaEscolhida;
                    switch (tipoVagaOpcao) {
                        case 1:
                            tipoVagaEscolhida = "Normal";
                            break;
                        case 2:
                            tipoVagaEscolhida = "Idoso";
                            break;
                        case 3:
                            tipoVagaEscolhida = "PCD";
                            break;
                        case 4:
                            tipoVagaEscolhida = "VIP";
                            break;
                        default:
                            System.out.println("Opção de vaga inválida.");
                            continue;
                    }

                    // Escolhe a primeira vaga disponível do tipo selecionado
                    Optional<Vaga> vagaDisponivel = a.getVagas().stream()
                        .filter(Vaga::estaDisponivel)
                        .filter(v -> v.getTipoVaga().equals(tipoVagaEscolhida))
                        .findFirst();

                    if (vagaDisponivel.isPresent()) {
                        Vaga vagaEscolhida = vagaDisponivel.get();
                        vagaEscolhida.ocupaVaga();
                        Cobranca novaCobranca = new Cobranca(veiculoEscolhido, vagaEscolhida, new Date());
                        cobrancas.add(novaCobranca);
                        System.out.println("Vaga " + vagaEscolhida.getId() + " (" + vagaEscolhida.getTipoVaga() + ") ocupada pelo veículo " + veiculoEscolhido.getPlaca());
                    } else {
                        System.out.println("Não há vagas disponíveis do tipo selecionado.");
                    }
                    break;

                case 3:
                    // Desocupar vaga e executar cobrança
                    System.out.println("Escolha o veículo pelo número da placa para desocupar:");
                    String placaParaDesocupar = scanner.next().toUpperCase();

                    Optional<Cobranca> cobrancaOptional = cobrancas.stream()
                        .filter(c -> c.getVeiculo().getPlaca().equals(placaParaDesocupar))
                        .findFirst();

                    if (cobrancaOptional.isPresent()) {
                        Cobranca cobranca = cobrancaOptional.get();
                        cobranca.registrarSaida(new Date());
                        cobranca.mostrarCobranca();

                        cobranca.getVaga().desocupaVaga();
                        cobrancas.remove(cobranca);

                        System.out.println("Vaga desocupada e cobrança realizada.");
                    } else {
                        System.out.println("Nenhuma cobrança encontrada para o veículo.");
                    }
                    break;
                    
                case 4:
                	Cobranca.lerRelatorio();
                	break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
