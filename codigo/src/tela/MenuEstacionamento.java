package tela;

import estacionamento.*;
import veiculos.Veiculo;
import vagas.*;
import java.util.Scanner;

public class MenuEstacionamento {
    private static Scanner scanner = new Scanner(System.in);
    private static Estacionamento estacionamento = new Estacionamento("Estacionamento Central");

    public static void displayMenu() {
        int opcao;
        do {
            System.out.println("\n===== Menu de Estacionamento =====");
            System.out.println("1. Adicionar Vaga");
            System.out.println("2. Estacionar Veículo");
            System.out.println("3. Liberar Vaga");
            System.out.println("4. Salvar Dados");
            System.out.println("5. Carregar Dados");
            System.out.println("6. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarVaga();
                    break;
                case 2:
                    estacionarVeiculo();
                    break;
                case 3:
                    liberarVaga();
                    break;
                case 4:
                    salvarDados();
                    break;
                case 5:
                    carregarDados();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);
        scanner.close();
    }

    private static void adicionarVaga() {
        System.out.println("Digite o tipo de vaga (Regular, Idoso, PCD, VIP):");
        String tipo = scanner.nextLine();
        System.out.println("Digite o ID da vaga:");
        String id = scanner.nextLine();
        Vaga vaga = VagaFactory.criarVaga(tipo, id);
        if (vaga != null) {
            estacionamento.adicionarVaga(vaga);
            System.out.println("Vaga adicionada com sucesso.");
        } else {
            System.out.println("Tipo de vaga inválido.");
        }
    }

    private static void estacionarVeiculo() {
        System.out.println("Digite a placa do veículo:");
        String placa = scanner.nextLine();
        System.out.println("Digite o ID da vaga onde deseja estacionar:");
        String idVaga = scanner.nextLine();
        Veiculo veiculo = new Veiculo(placa, "Cliente ID"); // Simplicidade, supondo um cliente já definido
        if (estacionamento.estacionarVeiculo(veiculo, idVaga)) {
            System.out.println("Veículo estacionado com sucesso.");
        } else {
            System.out.println("Falha ao estacionar o veículo.");
        }
    }

    private static void liberarVaga() {
        System.out.println("Digite o ID da vaga que deseja liberar:");
        String idVaga = scanner.nextLine();
        if (estacionamento.liberarVaga(idVaga)) {
            System.out.println("Vaga liberada com sucesso.");
        } else {
            System.out.println("Falha ao liberar a vaga.");
        }
    }

    private static void salvarDados() {
        DadosEstacionamento.salvarVagas(estacionamento.getVagas(), "vagas.txt");
        System.out.println("Dados salvos com sucesso.");
    }

    private static void carregarDados() {
        DadosEstacionamento.carregarVagas(estacionamento, "vagas.txt");
        System.out.println("Dados carregados com sucesso.");
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
