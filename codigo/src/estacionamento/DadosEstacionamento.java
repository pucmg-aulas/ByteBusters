package estacionamento;

import java.io.*;
import java.util.List;
import vagas.*;
import veiculos.Veiculo;

public class DadosEstacionamento {

    public static void salvarVagas(List<Vaga> vagas, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Vaga vaga : vagas) {
                writer.write(vaga.getTipo() + "," + vaga.getId() + "," + vaga.isOcupada() + "\n");
            }
            System.out.println("Vagas salvas com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar vagas: " + e.getMessage());
        }
    }

    public static void carregarVagas(Estacionamento estacionamento, String nomeArquivo) {
        estacionamento.limparVagas(); // Assume que esse método existe para limpar a lista de vagas
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                String id = partes[1];
                boolean ocupada = Boolean.parseBoolean(partes[2]);

                Vaga vaga = VagaFactory.criarVaga(tipo, id);
                if (ocupada) {
                    vaga.ocuparVaga(new Veiculo("XXX-XXXX", "ClienteID"));
                }
                estacionamento.adicionarVaga(vaga);
            }
            System.out.println("Vagas carregadas com sucesso do arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao carregar vagas: " + e.getMessage());
        }
    }
}
