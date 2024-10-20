package estacionamento;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento("Estacionamento A", "Rua A");
        List<Cliente> clientes = carregarClientes();
        Cliente.atualizarContador(clientes.stream().mapToInt(Cliente::getIdCliente).max().orElse(0));

        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Veículo");
            System.out.println("3. Criar Vaga");
            System.out.println("4. Mostrar Vagas");
            System.out.println("5. Ocupar Vaga");
            System.out.println("6. Desocupar Vaga e Executar Cobrança");
            System.out.println("7. Mostrar Relatório");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Cliente novoCliente = criarCliente(scanner);
                    clientes.add(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    salvarClientes(clientes);
                    break;

                case 2:
                    cadastrarVeiculo(scanner, clientes);
                    break;

                case 3:
                    criarVaga(scanner, estacionamento);
                    break;

                case 4:
                    estacionamento.mostrarEstacionamento();
                    estacionamento.mostrarVagas();
                    break;

                case 5:
                    ocuparVaga(scanner, clientes, estacionamento);
                    break;

                case 6:
                    desocuparVaga(scanner, estacionamento);
                    break;

                case 7:
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
    public static Cliente criarCliente(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        return new Cliente(nome);
    }

    public static void cadastrarVeiculo(Scanner scanner, List<Cliente> clientes) {
        System.out.println("Escolha o cliente:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + ". " + cliente.getNome());
        }

        int clienteOpcao = scanner.nextInt();
        scanner.nextLine();
        Cliente clienteSelecionado = clientes.stream()
                .filter(c -> c.getIdCliente() == clienteOpcao)
                .findFirst()
                .orElse(null);

        if (clienteSelecionado != null) {
            System.out.print("Digite a placa do veículo: ");
            String placa = scanner.nextLine().toUpperCase();
            Veiculo novoVeiculo = new Veiculo(placa);
            clienteSelecionado.registrarVeiculo(novoVeiculo);
            System.out.println("Veículo registrado com sucesso!");
            salvarClientes(clientes);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void criarVaga(Scanner scanner, Estacionamento estacionamento) {
        System.out.println("Escolha o tipo de vaga:");
        System.out.println("1. Normal");
        System.out.println("2. Idoso");
        System.out.println("3. PCD");
        System.out.println("4. VIP");

        int tipoVaga = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a letra da fila (A, B ou C): ");
        String fila = scanner.nextLine().toUpperCase();

        System.out.print("Digite o número da vaga: ");
        String numeroVaga = scanner.nextLine();

        Vaga novaVaga;

        switch (tipoVaga) {
            case 1:
                novaVaga = new Normal(fila, Integer.parseInt(numeroVaga));
                break;
            case 2:
                novaVaga = new Idoso(fila, Integer.parseInt(numeroVaga));
                break;
            case 3:
                novaVaga = new Pcd(fila, Integer.parseInt(numeroVaga));
                break;
            case 4:
                novaVaga = new Vip(fila, Integer.parseInt(numeroVaga));
                break;
            default:
                System.out.println("Tipo de vaga inválido.");
                return;
        }

        estacionamento.adicionarVaga(novaVaga);
        System.out.println("Vaga criada com sucesso: " + novaVaga.getId());
    }

    public static void ocuparVaga(Scanner scanner, List<Cliente> clientes, Estacionamento estacionamento) {
        System.out.println("Escolha o cliente:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + ". " + cliente.getNome());
        }

        Cliente clienteSelecionado = null;
        while (clienteSelecionado == null) {
            try {
                int clienteOpcao = scanner.nextInt();
                scanner.nextLine();

                clienteSelecionado = clientes.stream()
                        .filter(c -> c.getIdCliente() == clienteOpcao)
                        .findFirst()
                        .orElse(null);

                if (clienteSelecionado == null) {
                    System.out.println("Cliente não encontrado. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número correspondente ao cliente.");
                scanner.nextLine();
            }
        }

        // Solicita a placa do veículo que está ocupando a vaga
        System.out.print("Digite a placa do veículo: ");
        String placaVeiculo = scanner.nextLine().toUpperCase();
        Veiculo veiculo = clienteSelecionado.getVeiculos().stream()
                .filter(v -> v.getPlaca().equals(placaVeiculo))
                .findFirst()
                .orElse(null);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado para o cliente.");
            return;
        }

        System.out.println("Escolha o tipo de vaga:");
        System.out.println("1. Normal");
        System.out.println("2. Idoso");
        System.out.println("3. PCD");
        System.out.println("4. VIP");

        int tipoVaga = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a letra da fila (A, B ou C): ");
        String fila = scanner.nextLine().toUpperCase();

        System.out.print("Digite o número da vaga: ");
        String numeroVaga = scanner.nextLine();

        String idVaga = fila + String.format("%02d", Integer.parseInt(numeroVaga));

        Vaga vagaEncontrada = estacionamento.getVagas().stream()
                .filter(v -> v.getId().equals(idVaga) && v.estaDisponivel() &&
                        ((tipoVaga == 1 && v instanceof Normal) ||
                                (tipoVaga == 2 && v instanceof Idoso) ||
                                (tipoVaga == 3 && v instanceof Pcd) ||
                                (tipoVaga == 4 && v instanceof Vip)))
                .findFirst()
                .orElse(null);

        if (vagaEncontrada != null) {
            vagaEncontrada.ocupaVaga(veiculo); // Passa o veículo para o método
            System.out.println("Vaga ocupada com sucesso!");
        } else {
            System.out.println("Vaga não encontrada ou já está ocupada.");
        }
    }

    public static void desocuparVaga(Scanner scanner, Estacionamento estacionamento) {
        System.out.println("Digite seu nome:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite a letra da fila (A, B ou C) da vaga:");
        String fila = scanner.nextLine().toUpperCase();

        System.out.print("Digite o número da vaga: ");
        String numeroVaga = scanner.nextLine();

        String idVaga = fila + String.format("%02d", Integer.parseInt(numeroVaga));

        Vaga vagaEncontrada = estacionamento.getVagas().stream()
                .filter(v -> v.getId().equals(idVaga) && !v.estaDisponivel())
                .findFirst()
                .orElse(null);

        if (vagaEncontrada != null) {
            Date horaSaida = new Date(); // Registra a hora de saída
            Cobranca cobranca = new Cobranca(vagaEncontrada.getVeiculo(), vagaEncontrada, vagaEncontrada.getHoraChegada()); // Passa a hora de chegada
            cobranca.registrarSaida(horaSaida);
            vagaEncontrada.desocupaVaga();
            System.out.println("Vaga desocupada e cobrança registrada com sucesso!");
        } else {
            System.out.println("Vaga não encontrada ou já está livre.");
        }
    }

    public static void salvarClientes(List<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public static List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            clientes = (List<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
        return clientes;
    }
}
